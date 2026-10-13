# Craftgate Java Client

[![Build Status](https://github.com/craftgate/craftgate-java-client/actions/workflows/craftgate-build.yml/badge.svg?branch=master)](https://github.com/craftgate/craftgate-java-client/actions?query=branch%3Amaster)
[![Maven Central](https://img.shields.io/maven-central/v/io.craftgate/craftgate)](https://central.sonatype.com/artifact/io.craftgate/craftgate)
[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/craftgate/craftgate-java-client)

This repo contains the Java client for Craftgate API.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/craftgate/craftgate-java-client)

## Requirements
- Java 1.8 or newer

## Installation
Replace `VERSION` with the latest version shown on the Maven Central badge above.

Apache Maven:
```xml
<dependency>
  <groupId>io.craftgate</groupId>
  <artifactId>craftgate</artifactId>
  <version>VERSION</version>
</dependency>
```
Gradle Groovy DSL
```
implementation 'io.craftgate:craftgate:VERSION'
```
Gradle Kotlin DSL
```
implementation("io.craftgate:craftgate:VERSION")
```

## Usage
To access the Craftgate API you'll first need to obtain API credentials (e.g. an API key and a secret key). If you don't already have a Craftgate account, you can signup at [https://craftgate.io](https://craftgate.io)

Once you've obtained your API credentials, you can start using Craftgate by instantiating a `Craftgate` with your credentials.

```java

Craftgate craftgate = new Craftgate("<YOUR API KEY>", "<YOUR SECRET KEY>");
...

```

By default the Craftgate client connects to the production API servers at `https://api.craftgate.io`. For testing purposes, please use the sandbox URL `https://sandbox-api.craftgate.io`.

```java

Craftgate craftgate = new Craftgate("<YOUR API KEY>", "<YOUR SECRET KEY>", "https://sandbox-api.craftgate.io");
...

```

## Examples
Included in the project are a number of examples that cover almost all use-cases. Refer to [the `sample/` folder](./src/test/java/io/craftgate/sample) for more info.

### Running the Examples
The examples call the sandbox API, so first replace `api-key` and `secret-key` in the sample class you want to run with your sandbox credentials.

Run all examples:
```
./gradlew sampleTest
```
Run a single example:
```
./gradlew sampleTest --tests io.craftgate.sample.PaymentSample.create_payment
```

`./gradlew test` runs only the unit tests and does not call the API.

### Credit Card Payment Use Case
Let's quickly review an example where we implement a credit card payment scenario.

> For more examples covering almost all use-cases, check out the [examples in the `sample/` folder](./src/test/java/io/craftgate/sample)

```java
Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

List<PaymentItem> items = new ArrayList<>();

items.add(PaymentItem.builder()
        .name("item 1")
        .externalId(UUID.randomUUID().toString())
        .price(BigDecimal.valueOf(30))
        .build());

items.add(PaymentItem.builder()
        .name("item 2")
        .externalId(UUID.randomUUID().toString())
        .price(BigDecimal.valueOf(50))
        .build());

items.add(PaymentItem.builder()
        .name("item 3")
        .externalId(UUID.randomUUID().toString())
        .price(BigDecimal.valueOf(20))
        .build());

CreatePaymentRequest request = CreatePaymentRequest.builder()
        .price(BigDecimal.valueOf(100))
        .paidPrice(BigDecimal.valueOf(100))
        .walletPrice(BigDecimal.ZERO)
        .installment(1)
        .currency(Currency.TRY)
        .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
        .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
        .paymentPhase(PaymentPhase.AUTH)
        .card(Card.builder()
                .cardHolderName("Haluk Demir")
                .cardNumber("5258640000000001")
                .expireYear("2044")
                .expireMonth("07")
                .cvc("000")
                .build())
        .items(items)
        .build();

PaymentResponse response = craftgate.payment().createPayment(request);
System.out.println(String.format("Create Payment Result: %s", response));
```

### Idempotency
Mutating operations accept an optional idempotency key. Set it on the request object and the client sends it as the `x-idempotency-key` header, so a request can be safely retried (e.g. after a timeout) without the operation being performed twice — the server returns the result of the first request when it sees a repeated key.

Every request extends `BaseRequest`, which carries a `HeaderOptions` object, so the key is available on any request via the builder:

```java
CreatePaymentRequest request = CreatePaymentRequest.builder()
        .price(BigDecimal.valueOf(100))
        .paidPrice(BigDecimal.valueOf(100))
        .currency(Currency.TRY)
        .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
        .headerOptions(HeaderOptions.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .build())
        // ... other fields
        .build();

PaymentResponse response = craftgate.payment().createPayment(request);
```

Operations whose parameters live in the URL path (e.g. deletes) take a request object as well, so they can carry an idempotency key too:

```java
craftgate.payment().expireCheckoutPayment(ExpireCheckoutPaymentRequest.builder()
        .token("456d1297-908e-4bd6-a13b-4be31a6e47d5")
        .headerOptions(HeaderOptions.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .build())
        .build());
```

> Use a fresh key per distinct operation, and reuse the same key when retrying that operation.

> The API honours the key on `POST`, `PATCH` and `DELETE` only. It is ignored on `PUT` endpoints, so retrying one of those is not de-duplicated.

`HeaderOptions` is sent as headers only — it is excluded from serialization, so it never reaches the request body, the query string, or the request signature.

### Contributions
For all contributions to this client please see the contribution guide [here](CONTRIBUTING.md). By participating in this project, you agree to abide by our [Code of Conduct](CODE_OF_CONDUCT.md).

## Security
If you discover a security vulnerability, please review our [Security Policy](SECURITY.md) for how to report it responsibly.

## License
This project is licensed under the Apache License, Version 2.0 — see the [LICENSE](LICENSE) and [NOTICE](NOTICE.md) files for details.

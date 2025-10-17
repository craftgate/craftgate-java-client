# Craftgate Java Client

[![Build Status](https://github.com/craftgate/craftgate-java-client/actions/workflows/craftgate-build.yml/badge.svg?branch=master)](https://github.com/craftgate/craftgate-java-client/actions?query=branch%3Amaster)
[![Maven Central](https://img.shields.io/maven-central/v/io.craftgate/craftgate)](https://central.sonatype.com/artifact/io.craftgate/craftgate)
[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/craftgate/craftgate-java-client)

This repo contains the Java client for Craftgate API.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/craftgate/craftgate-java-client)

## Requirements
- Java 1.8 or newer

## Installation
Apache Maven:
```bash
<dependency>
  <groupId>io.craftgate</groupId>
  <artifactId>craftgate</artifactId>
  <version>1.0.72</version>
</dependency>
```
Gradle Groovy DSL
```
implementation 'io.craftgate:craftgate:1.0.72'
```
Gradle Kotlin DSL
```
implementation("io.craftgate:craftgate:1.0.72")
```

## Usage
To access the Craftgate API you'll first need to obtain API credentials (e.g. an API key and a secret key). If you don't already have a Craftgate account, you can signup at [https://craftgate.io](https://craftgate.io)

Once you've obtained your API credentials, you can start using Craftgate by instantiating a `Craftgate` with your credentials.

```java

Craftgate craftgate = new Craftgate("<YOUR API KEY>", "<YOUR SECRET KEY>");
...

```

By default the Craftgate client connects to the production API servers at `https://api.craftgate.io`. For testing purposes, please use the sandbox URL `https://sandbox-api.craftgate.io` using the .

```java

Craftgate craftgate = new Craftgate("<YOUR API KEY>", "<YOUR SECRET KEY>", "https://sandbox-api.craftgate.io");
...

```

## Examples
Included in the project are a number of examples that cover almost all use-cases. Refer to [the `sample/` folder](./src/test/java/io/craftgate/sample)] for more info.

### Running the Examples
If you've cloned this repo on your development machine and wish to run the examples you can run an example with the command `./gradlew test` or run single test with the command `./gradlew test --tests PaymentSample.create_payment_sample`

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

### Contributions
For all contributions to this client please see the contribution guide [here](CONTRIBUTING.md).

## License
MIT

# Craftgate Java Client

[![Build Status](https://github.com/craftgate/craftgate-java-client/workflows/Craftgate%20Java%20CI/badge.svg?branch=master)](https://github.com/craftgate/craftgate-java-client/actions)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.craftgate/craftgate/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.craftgate/craftgate)

This repo contains the Java client for Craftgate API.

## Requirements
- Java 1.8 or newer

## Installation
Apache Maven:
```bash
<dependency>
  <groupId>io.craftgate</groupId>
  <artifactId>craftgate</artifactId>
  <version>0.0.1</version>
</dependency>
```
Gradle Groovy DSL
```
implementation 'io.craftgate:craftgate:0.0.1'
```
Gradle Kotlin DSL
```
implementation("io.craftgate:craftgate:0.0.1")
```

## Usage
To access the Craftgate API you'll first need to obtain API credentials (e.g. an API key and a secret key). If you don't already have a Craftgate account, you can signup at [https://craftgate.io/](https://craftgate.io)

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

List<CreatePaymentItemDto> items = new ArrayList<>();

items.add(CreatePaymentItemDto.builder()
        .name("item 1")
        .externalId("110948")
        .price(BigDecimal.valueOf(30))
        .subMerchantMemberId(1L)
        .subMerchantMemberPrice(BigDecimal.valueOf(27))
        .build());

items.add(CreatePaymentItemDto.builder()
        .name("item 2")
        .externalId("110952")
        .price(BigDecimal.valueOf(50))
        .subMerchantMemberId(2L)
        .subMerchantMemberPrice(BigDecimal.valueOf(42))
        .build());

items.add(CreatePaymentItemDto.builder()
        .name("item 3")
        .externalId("100251")
        .price(BigDecimal.valueOf(20))
        .subMerchantMemberId(3L)
        .subMerchantMemberPrice(BigDecimal.valueOf(18))
        .build());

CreatePaymentRequest request = CreatePaymentRequest.builder()
        .price(BigDecimal.valueOf(100))
        .paidPrice(BigDecimal.valueOf(100))
        .walletPrice(BigDecimal.ZERO)
        .installment(1)
        .currency(CurrencyCode.TRY)
        .conversationId("asdjasdjasdfjhasd")
        .paymentGroup(PaymentGroup.PRODUCT)
        .paymentPhase(PaymentPhase.AUTH)
        .card(CardDto.builder()
                .cardHolderName("Pharmacy User")
                .cardNumber("5406670000000009")
                .expireYear("2035")
                .expireMonth("11")
                .cvc("123")
                .build())
        .items(items)
        .build();

PaymentResponse paymentResponse = craftgate.payment().createPayment(request);
System.out.println(String.format("Create Payment Result: %s", paymentResponse));
```

### Advanced Usage: Adapters
In reality, the `Craftgate` class serves as a collection of adapters that integrates with different parts of the API. While the intended usage for most use-cases is to instantiate a `Craftgate` instance (as illustrated in the examples above) and use its adapter accessors (e.g. `payment()`), you can also manually import a certain adapter class and instantiate it.

**Note:** When instantiating an adapter, you can use the same options as you would when instantiating a `Craftgate`

For all adapters in the `Craftgate`, their purposes, accessors, as well as direct import paths, refer to the list below:

| Adapter Name | Purpose | Accessor |
|--------------|---------|----------|
| `InstallmentAdapter` | Retrieving per-installment pricing information based on installment count or BIN number | `installment()` |
| `OnboardingAdapter` | Conducting CRUD operations on buyers and submerchants | `onboarding()` |
| `PaymentAdapter` | Conducting payments, retrieving payment information, managing stored cards | `payment()` |

## License
MIT

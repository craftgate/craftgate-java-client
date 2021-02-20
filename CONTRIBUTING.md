
# Contributing to Craftgate Java Client
As an open-source project, anyone can contribute to the development of `craftgate-java-client`. If you decide to do so, please be aware of the guidelines outlined below.

`craftgate-java-client` is written in Java, in order to contribute to the project, some familiarity with Java knowledge is required.

## Prerequisites
This project uses [junit](https://junit.org/junit5/) as its test runner. [Gson](https://github.com/google/gson) for serialization-deserialization operations, [Lombok](https://projectlombok.org/) as annotation processor. Required minimum java version is 1.8 and current build tool is gradle.

## Package Structure
The project has a straightforward package structure; the source files are located under the [src/](src), sample integrations are located under [io/craftgate/sample](src/test/java/io/craftgate/sample), and tests are located under [io/craftgate/unit](src/test/java/io/craftgate/unit). Any build or test/coverage artifacts are placed under untracked folder such as:

- `build` and `out`: Build artifacts

As outlined in the [README](./README.md), the bulk of the project is split into the following categories:

- Adapters: Located under the [io/craftgate/adapter](src/main/java/io/craftgate/adapter) package, these are classes that are responsible for managing a certain domain
- HttpClient: Located under [io/craftgate/net](src/main/java/io/craftgate/net), these are utility functions to handle the traffic between backend and client.
- Enumerations and Domain Objects: Located under [io/craftgate/model](src/main/java/io/craftgate/model), these are enumerations, constants and domain object models that can be used by request and response classes
- Requests: Located under [io/craftgate/request](src/main/java/io/craftgate/request), these are objects to be used as requests.
- Response: Located under [io/craftgate/response](src/main/java/io/craftgate/response), these are objects to be used as responses.

## Tests and Coverage
As a payment systems client, it's important to have tests covering critical parts. In addition to tests that test crucial parts of the libraries and utilities, all samples are provided as Junit tests. 
It is strongly advised for all contributors to run all samples/tests against the changes introduced in the pull request. If there are no corresponding tests against the changes introduced, owner of the pull request is responsible for adding any relevant tests or samples.

# java-15-lambda-container
A Sample of Java Lambda function with container image (using java 15 runtime)

## How to use
It is almost the same as [Creating Lambda container images](https://docs.aws.amazon.com/ja_jp/lambda/latest/dg/images-create.html)

### Local Debug

1. Build
    ```shell
    docker build -t java-lambda-container:latest .
    ```
2. Run
    ```shell
    docker run -p 9000:8080 java-lambda-container:latest
    ```
3. Send a request from another terminal
    ```shell
   curl -XPOST "http://localhost:9000/2015-03-31/functions/function/invocations" -d '{}'
   ```

### Deploy

1. Authenticate
   ```shell
   aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 123456789012.dkr.ecr.us-east-1.amazonaws.com
   ```
2. Tag and push
   ```shell
   docker tag  hello-world:latest 123456789012.dkr.ecr.us-east-1.amazonaws.com/hello-world:latest
   docker push 123456789012.dkr.ecr.us-east-1.amazonaws.com/hello-world:latest
   ```

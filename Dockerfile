FROM amazoncorretto:15

# set environment variables
ENV CLASSPATH /var/task/*

WORKDIR /var/task

# copy lambda execution files
COPY aws-lambda-rie /usr/local/bin/aws-lambda-rie
COPY lambda-entrypoint.sh /lambda-entrypoint.sh

# Copy function code
COPY build/libs/java-15-lambda-container-1.0-SNAPSHOT-all.jar /var/task/

# Set the Entrypoint
ENTRYPOINT ["/lambda-entrypoint.sh"]

# Set the CMD to your handler (could also be done as a parameter override outside of the Dockerfile)
CMD [ "example.Handler::handleRequest" ]

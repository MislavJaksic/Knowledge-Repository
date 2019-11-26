FROM ibmjava:8-sfj-alpine

RUN apk add --no-cache bash

WORKDIR /opt

COPY javaprogram.jar .

CMD ["java", "-DID=my-id", "-jar", "./javaprogram.jar"]

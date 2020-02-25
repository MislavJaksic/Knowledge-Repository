FROM ibmjava:8-sfj-alpine

ENV VERSION_NUMBER 1.2

RUN apk add --no-cache bash

WORKDIR /opt

COPY javaprogram.jar .

CMD ["java", "-DID=my-id", "-jar", "./javaprogram-$VERSION_NUMBER.jar"]

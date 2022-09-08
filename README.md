# Event Generator

This app starts a server listening on port 9090. Once a client connects, newline
separated events will start streaming to it.

Each event will look like this:

```
id,location,temp,battery
```

## To run with Docker

`docker build --tag event-generator:latest .`

`docker run -p 9090:9090 event-generator`

## To run without Docker

`javac src/*.java -d out`

`cd out && java App`

A simple Spring Boot websocket messaging server. Companion to [this React websocket client](https://github.com/andrew-d-taylor/websocket-react)

Run `WebSocketServerApplication` and establish a websocket connection
to `localhost:8080/websocket-stomp-endpoint`, where you can subscribe to the following topics:

- `/app/messages`: responds with the baseline set of existing messages
- `/topic/messages`: for any new messages processed by the server

To create a message, just submit content to `app/messages/create`
in the form of:
    <br>`{ label:string, content:string, timestamp:string }`<br>
    
The app also offers the following REST endpoints:

- `GET "/messages"` - returns the set of existing messages<br>
- `POST "/messages"` - creates a new message from the body of the request
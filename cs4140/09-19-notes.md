
**HTTP and State**

HTTP/1.0 was stateless.

 - The client sent a request.
 - The server responded to that request.
 - There was no way to figure out that requests went together.

In early web apps, state was simulated with embedded session codes
in links and forms.

e.g. `<a href="/about?session=29">About</a>`

New plan: Cookies

In HTTP/1.1:

- Server sends "set-cookie: session_id=29" header.
- Every subsequent request from browser to that site sends 
  "cookie: session_id=29".

**Server-side statelessness.**

- Web app servers were historically typically written to only think
  about one request at a time.
- This allows good scaling with multiple processes / threads:
  - Get connection / request.
  - Spawn thread to handle it.
  - Thread handles it sequentially, maybe with DB requests.
  - Thread sends response.
  - Thread terminates.

**Feature: AJAX / Fetch**

- Browser APIs allow JS code to make HTTP requests to server without
  doing a full page reload.
- Problem: Browser must initiate request, no way for server to send
  a message to brower code.


**Feature: Websockets**

- HTTP (connect, request, response, disconnect) runs on top of TCP (connect,
bidirectoinal stream, stay connected).
- Websockets is an "upgrade" header that makes the HTTP connection not
disconnect and basically turn back into TCP.







# What is web development?

Web sites? That's web design

Web: 

Internet: Two parts, inter net

Network: Computers that are connected

Internet: A big network of networks

We can run applications over a network, or the internet.

One application: The web

The web has two key parts:

- Web Browsers - client apps that run on user devices.
- A bunch of standards:
  - a protocol: HTTP
  - a bunch of standard file formats: HTML, JS, CSS, GIF, PNG,
    JPEG, ...
- Web page: An HTML document
- Web site: A collection of web pages that go together


Development: We're talking about software development, so we're 
writing code.

The early versions of the web worked like this:

- The browser could display HTML with embedded GIF.
- It connected to a web server, which served one web site
  which was just a directory with files in it.

- The browser requests a URL: http://www.stanford.edu/~zlu/robotics.html
- The web server looks for a file called ~zlu/robotics.html under its
  document root. 

There are two places to write code:

- You can write JavaScript that can run in the web browser.
- We don't have to run a web server that just responds to requests
  by reading files from disk and sending them. We can write whatever
  program we want that speaks HTTP, and basically have a
  function `handle_request(http_req) -> http_resp`.
- Any program that can listen on a network socket and process
  text can be an HTTP server, and thus a target for server-side
  web dev.

## The Elixir Language

Elixir runs on the Erlang virtual machine, and is semantically
basically the same as the Erlang language. The syntax hurts less
though.

Why Erlang VM?

Erlang was developed in the 80's at Erikson, for telecom switches.
Main goal: Near 100% uptime.

We need hardware redundancy, which means the software needs to handle
being distributed across multiple machines.

Erlang / Elixir is really good at:

- Distributed redudancy -> reliabiliy
- I/O performance
- Crash recovery
- Concurrency




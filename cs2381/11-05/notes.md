
# Threads

Sometimes we want to do more than one thing at the same time ("concurrently").

Why?

Example: A Network Server

- We are listening for HTTP requests
- Alice requests /huge-video.mp4, which is 17 GB.
- Bob requests /index.html, which is 100 kB.

In a non-concurrent (sequential) server, Bob will have to wait
for Alice to finish her download.

Example: GUI App

- Photo editing app.
- User clicks the "Fill in the sky with AI-generated clouds" button.
- Then the user tries to scroll down to see the bottom of the picture.

Example: Compiling a big C program.

- Sequential: One file at a time.
- Concurrent: Multiple files a time, logically.
- Parallel: Actually compile multiple files on multiple CPU cores.
  - This allows computationally intensive programs to finish faster.

## Threads

By default, a program has one running thread (sequence of execution)
that runs on one core.

We can add more threads, which can be scheduled independently and run
concurrently and/or in parallel.


# Running LLMs Locally

Broad topic: How to use LLMs in our programs.

### What are LLMs?

Artificial Intelligence, like in "The Terminator"

Neural Network

- A graph of "artificial neurons"
- Specifically, a directed acyclic graph that transforms
  an input into an output- A vector is a 1D array of numbers.
- A matrix is a 2D array of numbers.
- A tensor is an N-D array of numbers, for any N..
- Stored as "tensors" of weights.

Tensors

- A scalar is one number.
- A vector is a 1D array of numbers.
- A matrix is a 2D array of numbers.
- A tensor is an N-D array of numbers, for any N.

LLM sequence:

- What LLMs do is predict the next token in a sequence.
- Tokens are basically words, converted to numbers using
  a dictionary.
  - e.g. aardvark might be 1
  - Some fanciness: aardvarks might be two tokens (aardvark) (-s for plural)
- First, input text is transformed into a vector of tokens.
- Then the vector of tokens gets translated into a vector of embeddings
- An embedding is a big tensor where the internal numbers make similar
  tokens have similar values. Position in input is also encoded here.
- Then our embeddings are fed thorugh the rest of the network to get
  a next token prediction.
- That token goes on the end of the input token vector, repeat.

Base models:

- Are trained to produce sequences like the training data.
- If trained on novels, they'll spit out the second half of a chapter
  given the first half.

Instruct model:

- Trained to follow a chat format and obey directions.

How big a model?

- We measure model size in terms of number of weights.
  - A 7B model has 7 billion weights for all the nodes in the
    graph.
  - Those are stored as 7 billion numbers.
  - At 32-bit precision, a 7B model would take 28 GB of storage.
- How many bits do we really need per weight?
  - 16 bit floats work fine, this is standard precision for LLMs.
  - Models get "quantized" down smaller than that, which in the
    context of LLMs means very cleverly compressed.
  - An 8 bit per weight quant maintains most of the quality.
  - Can go down to 4 bits per weight with decent quality.

To run an LLM, we've got to load the whole thing into RAM.

- Optimally, into video RAM.

- We also need to do a lot of matrix multiplication on the data,
  so we want a lot of compute power too.

### How do we run them locally?

- Need a computer with sufficient specs to run the model
  we want.
  - RAM quantity
  - Memory bandwidth
  - Compute power
  - That might mean having a fancy GPU

Software, two major options

- Python / Transformers library (needed for training)
- llama.cpp (fast for inference)

Need to get a model to run

- The site right now is HuggingFace

Once you have the model, you can run it locally with llama-server.

To code against it: Use an API client library.

### Why not just use an LLM cloud service?

- Don't need to use network (both cost and flexibility).
- It might be cheaper, and it's certainly not billed per request.
- Privacy / compliance concerns.
- For small tasks not running your own software is just silly.

Exceptions:

- Some models are too big to run locally at a given budget.

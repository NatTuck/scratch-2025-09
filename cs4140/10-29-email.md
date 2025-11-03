
# 10-29 Too Much Detail About Email

Conceptually, email should be easy:

- We just need to:
  - Figure out the email server for the recipient.
  - Connect to that server on the email port.
  - Send an email.
- It's even easier than that.
  - If we have a local mail server, it'll figure out
    how to forward to the right place.

Problem: It's too easy.

- By the late 90's, spam had taken over email.
- This lead to spam filtering.

How mail servers decide what email to accept.

- Protocol compliance checks.
- Check against "realtime blackhole lists"
- Sender authentication checks:
  - SPF: Specifies mail servers allowed to send for domains.
  - DKIM: Similar, but with cryptographic signatures.
  - DMARC: Another one.
- Other domain/IP reputation rules
- Spam filtering

Setting things up so that major providers will accept your
email is annoying.

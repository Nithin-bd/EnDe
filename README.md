
# AES File Encryption and Decryption using Java Swings

This project can be used as a Java applet. It encrypts and decrypts files within the same folder location using Advanced Encryption Standard (AES) 256, which is a symmetric encryption algorithm that uses a 256-bit key to convert your plain text or data into a cipher. 

![gui](https://github.com/Nithin-bd/EnDe/assets/83744735/ebc56ee4-2846-4065-981a-4da46e772bb1)

## How it works

There are 4 main components:
`Chooser`
`Encrypt`
`Decrypt`
`Extention`

## Encryption

- To encrypt a file you 1st need to select the file location using the `Chooser` button.
- Next click on the `Encrypt` button. This should encrypt the file in the same location as the application with file name `locked.encrypted`.
- If the encryption was sucessful you will receive the pop-up say `sucessful encryption` and a file called `locked.encryption` will be generated in the same directory.

## Decryption

Decryption follows a similar process as encryption.

- The `locked.encryption` file should be selected.
- Next type the file `Extention` of the original file and hit the `Decrypt` button.
- If the decryption was sucessful you will receive the pop-up say `sucessful decryption` and a file called `decrypt.[file extention]` will be generated in the same directory.

## License

MIT License

Copyright (c) 2023 Nithin-bd

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

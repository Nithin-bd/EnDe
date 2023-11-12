
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

[MIT](https://choosealicense.com/licenses/mit/)

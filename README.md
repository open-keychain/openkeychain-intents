# OpenKeychain API library

Just the Intents to start OpenKeychain for certain actions, e.g., encrypt a file.

## License
While OpenKeychain itself is GPLv3+, the API library is licensed under Apache License v2.
Thus, you are allowed to also use it in closed source applications as long as you respect the [Apache License v2](https://github.com/open-keychain/openkeychain-intents/blob/master/LICENSE).

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


## Add the API library to your project

Add this to your build.gradle:

```
repositories {
    jcenter()
}

dependencies {
    compile 'org.sufficientlysecure:openkeychain-intents:3.0'
}
```

## Usage

All Intents require user interaction, e.g. to finally encrypt the user needs to press the "Encrypt" button.
To do automatic encryption/decryption/sign/verify use the OpenPGP Remote API.

#### Android Intent actions:

* ``android.intent.action.VIEW`` connected to .gpg and .asc files: Import Key and Decrypt
* ``android.intent.action.SEND`` connected to all mime types (text/plain and every binary data like files and images): Encrypt and Decrypt
* ``android.intent.action.SEND_MULTIPLE`` connected to all mime types except ``text/*`` and ``message/*``

#### Preferred MIME types
* ``application/pgp-message`` for encrypted OpenPGP data
* ``application/pgp-keys`` to import OpenPGP keys

#### OpenKeychain Intent actions:

We are following [Android Guidelines](http://developer.android.com/guide/components/intents-filters.html) by including the full package name as a prefix.

* ``org.sufficientlysecure.keychain.action.ENCRYPT_TEXT``
  * ``org.sufficientlysecure.keychain.action.EXTRA_TEXT``: To encrypt or sign text, use this extra (type: ``String``)
* ``org.sufficientlysecure.keychain.action.ENCRYPT_DATA``
  * Set data ``Uri`` (``intent.setData()``) pointing to a file/image, anything that can be read via an InputStream
  * ``org.sufficientlysecure.keychain.action.EXTRA_ASCII_ARMOR``: Enable ASCII Armor for file encryption (encoding to Radix-64, 33% overhead) by adding the extra with value ``true``
* ``org.sufficientlysecure.keychain.action.DECRYPT_TEXT``
  * ``org.sufficientlysecure.keychain.action.EXTRA_TEXT``: To decrypt or verify text, use this extra (type: ``String``)
* ``org.sufficientlysecure.keychain.action.DECRYPT_DATA``
  * Set data ``Uri`` (``intent.setData()``) pointing to a file
* ``org.sufficientlysecure.keychain.action.IMPORT_KEY``
  * ``org.sufficientlysecure.keychain.action.EXTRA_KEY_BYTES``: key as byte array (type: ``byte[]``)
  * or set data ``Uri`` (``intent.setData()``) pointing to a file
* ``org.sufficientlysecure.keychain.action.IMPORT_KEY_FROM_KEYSERVER``
  * ``org.sufficientlysecure.keychain.action.EXTRA_QUERY``:Extras: ``query`` (type: ``String``)
  * or ``org.sufficientlysecure.keychain.action.EXTRA_FINGERPRINT`` (type: ``String``)
* ``org.sufficientlysecure.keychain.action.IMPORT_KEY_FROM_QR_CODE``
  * without extras, starts Barcode Scanner to get QR Code
  

#### QR Codes
* ``android.intent.action.VIEW`` with URIs following the ``openpgp4fpr`` (OpenPGP version 4 fingerprint) schema. For example: ``openpgp4fpr:73EE2314F65FA92EC2390D3A718C070100012282``. This is used in QR Codes, but could also be embedded into your website. (compatible with Monkeysphere's and Guardian Project's QR Codes)
* Versioning the scheme makes sense, v3 fingerprints (MD5) are unsecure, v4 is current default
* More infos: https://github.com/ModernPGP/QR/commit/bea5b1298d352c0b53cac7e214264042de6ff79a

#### NFC
* NFC (``android.nfc.action.NDEF_DISCOVERED``) on mime type ``application/pgp-keys`` (as specified in http://tools.ietf.org/html/rfc3156, section 7)
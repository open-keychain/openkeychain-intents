/*
 * Copyright (C) 2014 Dominik Schürmann <dominik@dominikschuermann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sufficientlysecure.keychain.api;

public class OpenKeychainIntents {
    public static final String PACKAGE_NAME = "org.sufficientlysecure.keychain";

    // prefix packagename for exported Intents
    // as described in http://developer.android.com/guide/components/intents-filters.html
    public static final String INTENT_PREFIX = PACKAGE_NAME + ".action.";
    public static final String EXTRA_PREFIX = PACKAGE_NAME + ".";

    public static final String ENCRYPT_TEXT = INTENT_PREFIX + "ENCRYPT_TEXT";
    public static final String ENCRYPT_EXTRA_TEXT = EXTRA_PREFIX + "EXTRA_TEXT"; // String

    public static final String ENCRYPT_DATA = INTENT_PREFIX + "ENCRYPT_DATA";
    public static final String ENCRYPT_ASCII_ARMOR = EXTRA_PREFIX + "EXTRA_ASCII_ARMOR"; // boolean

    public static final String DECRYPT = INTENT_PREFIX + "DECRYPT";
    public static final String DECRYPT_EXTRA_TEXT = EXTRA_PREFIX + "EXTRA_TEXT"; // String

    public static final String IMPORT_KEY = INTENT_PREFIX + "IMPORT_KEY";
    public static final String IMPORT_KEY_EXTRA_KEY_BYTES = EXTRA_PREFIX + "EXTRA_KEY_BYTES"; // byte[]

    public static final String IMPORT_KEY_FROM_KEYSERVER = INTENT_PREFIX + "IMPORT_KEY_FROM_KEYSERVER";
    public static final String IMPORT_KEY_FROM_KEYSERVER_QUERY = EXTRA_PREFIX + "EXTRA_QUERY"; // String
    public static final String IMPORT_KEY_FROM_KEYSERVER_FINGERPRINT = EXTRA_PREFIX + "EXTRA_FINGERPRINT"; // String

    public static final String IMPORT_KEY_FROM_QR_CODE = INTENT_PREFIX + "IMPORT_KEY_FROM_QR_CODE";

}

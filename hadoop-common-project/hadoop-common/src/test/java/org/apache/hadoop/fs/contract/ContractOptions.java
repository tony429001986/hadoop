/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.fs.contract;

/**
 * Options for contract tests: keys for FS-specific values,
 * defaults.
 */
public interface ContractOptions {


  /**
   * name of the (optional) resource containing filesystem binding keys : {@value}
   * If found, it it will be loaded
   */
  String CONTRACT_OPTIONS_RESOURCE = "contract-test-options.xml";

  /**
   * Prefix for all contract keys in the configuration files
   */
  String FS_CONTRACT_KEY = "fs.contract.";

  /**
   * Flag to indicate that a newly created file may overwrite a pre-existing
   * directory.
   * {@value}
   */
  String CREATE_OVERWRITES_DIRECTORY = "create-overwrites-directory";

  /**
   * Flag to indicate that a newly created file is not made visible in the
   * namespace immediately.  Instead, the file becomes visible at a later point
   * in the file creation lifecycle, such as when the client closes it.
   * {@value}
   */
  String CREATE_VISIBILITY_DELAYED = "create-visibility-delayed";

  /**
   * Flag to indicate that it is possible to create a file under a file.
   * This is a complete violation of the filesystem rules, but it is one
   * which object stores have been known to do for performance
   * <i>and because nobody has ever noticed.</i>
   * {@value}
   */
  String CREATE_FILE_UNDER_FILE_ALLOWED = "create-file-under-file-allowed";

  /**
   * Is a filesystem case sensitive.
   * Some of the filesystems that say "no" here may mean
   * that it varies from platform to platform -the localfs being the key
   * example.
   * {@value}
   */
  String IS_CASE_SENSITIVE = "is-case-sensitive";

  /**
   * Blobstore flag. Implies it's not a real directory tree and
   * consistency is below that which Hadoop expects
   * {@value}
   */
  String IS_BLOBSTORE = "is-blobstore";

  /**
   * Flag to indicate that the FS can rename into directories that
   * don't exist, creating them as needed.
   * {@value}
   */
  String RENAME_CREATES_DEST_DIRS = "rename-creates-dest-dirs";

  /**
   * Flag to indicate that the FS does not follow the rename contract -and
   * instead only returns false on a failure.
   * {@value}
   */
  String RENAME_OVERWRITES_DEST = "rename-overwrites-dest";

  /**
   * Flag to indicate that the FS returns false if the destination exists
   * {@value}
   */
  String RENAME_RETURNS_FALSE_IF_DEST_EXISTS =
      "rename-returns-false-if-dest-exists";

  /**
   * Flag to indicate that the FS returns false on a rename
   * if the source is missing
   * {@value}
   */
  String RENAME_RETURNS_FALSE_IF_SOURCE_MISSING =
      "rename-returns-false-if-source-missing";

  /**
   * Flag to indicate that the FS remove dest first if it is an empty directory
   * mean the FS honors POSIX rename behavior.
   * {@value}
   */
  String RENAME_REMOVE_DEST_IF_EMPTY_DIR = "rename-remove-dest-if-empty-dir";

  /**
   * Flag to indicate that append is supported
   * {@value}
   */
  String SUPPORTS_APPEND = "supports-append";

  /**
   * Flag to indicate that setTimes is supported.
   * {@value}
   */
  String SUPPORTS_SETTIMES = "supports-settimes";

  /**
   * Flag to indicate that getFileStatus is supported.
   * {@value}
   */
  String SUPPORTS_GETFILESTATUS = "supports-getfilestatus";

  /**
   * Flag to indicate that renames are atomic
   * {@value}
   */
  String SUPPORTS_ATOMIC_RENAME = "supports-atomic-rename";

  /**
   * Flag to indicate that directory deletes are atomic
   * {@value}
   */
  String SUPPORTS_ATOMIC_DIRECTORY_DELETE = "supports-atomic-directory-delete";

  /**
   * Does the FS support multiple block locations?
   * {@value}
   */
  String SUPPORTS_BLOCK_LOCALITY = "supports-block-locality";

  /**
   * Does the FS support the concat() operation?
   * {@value}
   */
  String SUPPORTS_CONCAT = "supports-concat";

  /**
   * Is seeking supported at all?
   * {@value}
   */
  String SUPPORTS_SEEK = "supports-seek";

  /**
   * Is seeking past the EOF allowed?
   * {@value}
   */
  String REJECTS_SEEK_PAST_EOF = "rejects-seek-past-eof";

  /**
   * Is seeking on a closed file supported? Some filesystems only raise an
   * exception later, when trying to read.
   * {@value}
   */
  String SUPPORTS_SEEK_ON_CLOSED_FILE = "supports-seek-on-closed-file";

  /**
   * Is available() on a closed InputStream supported?
   * {@value}
   */
  String SUPPORTS_AVAILABLE_ON_CLOSED_FILE = "supports-available-on-closed-file";

  /**
   * Flag to indicate that this FS expects to throw the strictest
   * exceptions it can, not generic IOEs, which, if returned,
   * must be rejected.
   * {@value}
   */
  String SUPPORTS_STRICT_EXCEPTIONS = "supports-strict-exceptions";

  /**
   * Are unix permissions
   * {@value}
   */
  String SUPPORTS_UNIX_PERMISSIONS = "supports-unix-permissions";

  /**
   * Is positioned readable supported? Supporting seek should be sufficient
   * for this.
   * {@value}
   */
  String SUPPORTS_POSITIONED_READABLE = "supports-positioned-readable";

  /**
   * Indicates that FS exposes durable references to files.
   */
  String SUPPORTS_FILE_REFERENCE = "supports-file-reference";

  /**
   * Indicates that FS supports content checks on open.
   */
  String SUPPORTS_CONTENT_CHECK = "supports-content-check";

  /**
   * Indicates that FS supports unbuffer.
   */
  String SUPPORTS_UNBUFFER = "supports-unbuffer";

  /**
   * Maximum path length
   * {@value}
   */
  String MAX_PATH_ = "max-path";

  /**
   * Maximum filesize: 0 or -1 for no limit
   * {@value}
   */
  String MAX_FILESIZE = "max-filesize";

  /**
   * Flag to indicate that tests on the root directories of a filesystem/
   * object store are permitted
   * {@value}
   */
  String TEST_ROOT_TESTS_ENABLED = "test.root-tests-enabled";

  /**
   * Limit for #of random seeks to perform.
   * Keep low for remote filesystems for faster tests
   * {@value}
   */
  String TEST_RANDOM_SEEK_COUNT = "test.random-seek-count";

  /**
   * Is hflush supported in API and StreamCapabilities?
   */
  String SUPPORTS_HFLUSH = "supports-hflush";

  /**
   * Is hsync supported in API and StreamCapabilities?
   */
  String SUPPORTS_HSYNC = "supports-hsync";

  /**
   * Is the metadata updated after an hsync?
   * HDFS does not do this.
   */
  String METADATA_UPDATED_ON_HSYNC = "metadata_updated_on_hsync";

  /**
   * Does vector read check file length on open rather than in the read call?
   */
  String VECTOR_IO_EARLY_EOF_CHECK = "vector-io-early-eof-check";

  String VECTOR_IO_OVERLAPPING_RANGES = "vector-io-overlapping-ranges";
}

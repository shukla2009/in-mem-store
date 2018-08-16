In-Memory Key-Value Store
=========================

The objective of this coding challenge is to design, implement and test an in-memory key-value store.

API
---

The key-value store must support the following operations:

+ The `put` operation associates a given value to a given key in a given namespace.
+ The `get` operation returns the value which is associated to a given key in a given namespace.
+ The `delete` operation removes the association of any value to a given key in a given namespace.
+ The `values` operation returns a collection of all values which are associated to any keys in a given namespace. 

All operations share common properties:

+ Keys and namespaces are strings.
+ Values are serializable objects.
+ Operations can throw a custom, but common type of exceptions.
+ Optional: Looking up the namespace and operating on the namespace can be factored out into separate interfaces.

Requirements
------------

+ Protective copies must be made of the values when writing and reading them to/from the store.
+ Multiple threads can use the same key-value store concurrently.
+ All requirements should be fully covered by test code.

Deliverables
------------

The API, an implementation and its test code.
The implementation must pass the test code.

Prerequisites
-------------

+ Any Java SE 8 or later
+ Apache Maven 3.3.9 or later 

How To Build The Software
-------------------------

This repository uses Maven for compiling and testing the software.
The build definition is in the file `pom.xml`.
YOU MUST NOT MODIFY THIS FILE - ANY CHANGE WILL RESULT IN YOUR DISQUALIFICATION!

To compile and test your software, use

    mvn clean verify

You will need to have at least 60% code coverage in your test cases or otherwise the build will fail - this is a hard 
requirement.

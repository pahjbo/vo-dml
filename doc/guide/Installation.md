Installation
============

The VO-DML tooling is based around [gradle](https://gradle.org) which itself
is based on Java. It is recommended that a minimum of JDK 11 is installed 
(to be compatible with other tools) using a package manager for your OS and 
similarly use a package manager for gradle installation.

The functionality of the tooling is then encapsulated with a gradle plugin which
is configured [in the quickstart instructions](QuickStart.md)

Note the documentation tasks of the tools that produce the overall model diagram also require that [graphviz](https://graphviz.org)  be installed. 

If full site generation is required then [mkdocs material theme](https://squidfunk.github.io/mkdocs-material/getting-started/) is needed as an external installation dependency along with [yq](https://github.com/mikefarah/yq/#install) that can be used to automate the mkdocs navigation menu creation.
#!/bin/bash
GROOVY_VERSION="2.3.0"
# Basic CI Build

function execute() {
    ${@}
    if [ $? -ne 0 ]; then
        echo "[Execute] Failed! Command '${@}' exited with a non-zero status"
        exit 1
    fi
}

function cleanup() {
    execute rm -rf ${HOME}/.tools/groovy*
}

# Begin Setup Groovy #
function install_groovy() {
    ORIG_DIR=`pwd`
    cd ~
    [ ! -d .tools/ ] && mkdir .tools/
    cd .tools/
    echo "[Dependencies] Installing Groovy ${GROOVY_VERSION}..."
    execute wget --quiet http://dl.bintray.com/groovy/maven/groovy-binary-${GROOVY_VERSION}.zip -O groovy.zip
    execute unzip -qq groovy.zip
    export GROOVY_HOME=$(pwd)/groovy-${GROOVY_VERSION}/
    cd ${ORIG_DIR}
}
install_groovy
# End Setup Groovy #

for PROTOTYPE in `ls prototype/`
do
  echo "[Testing] Executing Prototype: ${PROTOTYPE}"
  execute ${GROOVY_HOME}/bin/groovy prototype/${PROTOTYPE}
  if [ $? -ne 0 ]; then
    echo "[Testing] Prototype Failed: ${PROTOTYPE}"
    exit 1
  fi
done

cleanup
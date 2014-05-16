#!/bin/bash

# Basic CI Build

function execute() {
    ${@}
    if [ $? -ne 0 ]; then
        echo "[Execute] Failed! Command '${@}' exited with a non-zero status"
        exit 1
    fi
}

# Begin Setup Groovy #
if [ ! -d "${HOME}/.gvm" ]; then
    execute curl -s get.gvmtool.net | bash
    source ~/.gvm/bin/gvm-init.sh
    execute echo 'gvm_auto_answer=true' > ~/.gvm/etc/config
    execute echo 'gvm_auto_selfupdate=false' >> ~/.gvm/etc/config
    execute gvm install groovy 2.3.0
else
    source ~/.gvm/bin/gvm-init.sh
fi
# End Setup Groovy #

execute gvm use groovy 2.3.0

for PROTOTYPE in `ls prototype/`
do
  echo "[Testing] Executing Prototype: ${PROTOTYPE}"
  execute groovy prototype/${PROTOTYPE}
  if [ $? -ne 0 ]; then
    echo "[Testing] Prototype Failed: ${PROTOTYPE}"
    exit 1
  fi
done
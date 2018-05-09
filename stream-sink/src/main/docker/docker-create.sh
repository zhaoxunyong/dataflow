#!/bin/sh
registry=192.168.100.87:5000
version=1.4.0-SNAPSHOT

docker pull ${registry}/hkcash/config-server:${version}

sudo mkdir -p /works/log/hkcash

docker run -d --net=hkcash --name config-server -p 8100:8100 \
 -v /works/app/hkapp/config-server:/works/app/config-server \
 -v /works/app/hkapp/config-server:/works/conf/config-server \
 -v /works/log/hkcash/config-server:/works/log/hkcash/config-server \
 ${registry}/hkcash/config-server:${version}

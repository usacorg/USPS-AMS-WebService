#
# Project: USPS-AMS-WebService
# Organization: New York State Senate
#

TARGETS= libamsnative.so

libamsnative.so: AmsNativeDao.c
	$(CC) -O0 -g -shared -fPIC -o $@ -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -I/usr/local/lib64/ams -Wall $+ -L/usr/local/lib64/ams -lz4lnx64

clean:
	rm -rf libamsnative.so


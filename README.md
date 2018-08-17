#  Prerequisites

* Java 10
* sbt (Scala Build Tool)

## Linux
### Install Java:
```
$ sudo add-apt-repository ppa:linuxuprising/java
$ sudo apt-get update
$ sudo apt-get install oracle-java10-installer

$ sudo apt-get install oracle-java10-set-default
```
### Verify installation:
```
$ java --version
```

### Install sbt:
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list

sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823

sudo apt-get update
sudo apt-get install sbt
```


## Mac

### Install Java:


1. [Download](http://www.oracle.com/technetwork/java/javase/downloads/jre10-downloads-4417026.html) the JRE .dmg file, jre-10.interim.update.patch_osx-x64_bin.dmg.
Before the file can be downloaded, you must accept the license agreement.

2. From either the browser Downloads window or from the file browser, double-click the .dmg file to launch it.
A Finder window appears that contains an icon of an open box and the name of the .app file.

3. Double-click the Java 10.app icon to start the installation application.
The installation application displays the Welcome window.

4. Click Next.
The software is installed and a confirmation window is displayed.

5. Click Close.

### Install sbt:
```
$ brew install sbt
```

# Running the application
From the root directory run:
```
$ sbt run
```

## Transaction
**URL:** /sales  
**Method:** POST  
**Content-Type:** application/x-www-form-urlencoded  
**Parameters:**

|    Name    |    Required    |    Type    |
|------------|:--------------:|------------|
|sales_amount|      Yes       |Number String (e.g. "10.00")|


**Return HTTP Code:​**  202 Accepted  
**Return Body:** ​ blank


## Statistic
**URL:** /statistics  
**Method:** ​ GET  
**Parameters:** ​ none  
**Return HTTP Code:​**​ 200 OK  
**Return Body:**

```
{
	total_sales_amount: “1000000.00”,
	average_amount_per_order: “45.04”
}
```
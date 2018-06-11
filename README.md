# qloyalcodetest-mobile-aws : This project is executed on AWS Device Farm

### 1. git clone git@github.com:hp-tech101/qloyalcodetest-mobile-aws.git
### 2. Passphrase: Success17$$18
### 3. cd qloyalcodetest-mobile-aws
### 4. mvn clean
### 5. mvn compile
### 6. Create a zip file to run on AWSDeviceFarm
   #### mvn clean package -DskipTests=true
### 7. Zip is created as follows:
   ####   ./target/zip-with-dependencies.zip
### 8. This zip can be used to create a run on AWS Device Farm
   #### To checkout the last run go to Device Farm on AWS Console with following credentials
     ##### user: himanshu.tech101@gmail.com
	   ##### pass: Success17$$18

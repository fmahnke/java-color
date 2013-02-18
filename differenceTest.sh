#!/bin/bash

java -cp .:target/classes:/Users/fmahnke/.m2/repository/com/beust/jcommander/1.30/jcommander-1.30.jar com.fritzmahnke.color.CommandLineParser difference --files src/test/resources/mb_01.txt src/test/resources/mb_03.txt


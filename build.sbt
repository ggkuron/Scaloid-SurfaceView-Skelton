import android.Keys._

android.Plugin.androidBuild

platformTarget in Android := "android-18"

name := "surface-test"

scalaVersion := "2.11.0"

proguardCache in Android ++= Seq(
  ProguardCache("org.scaloid") % "org.scaloid"
)

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-dontwarn scala.collection.mutable.**")

libraryDependencies += "org.scaloid" %% "scaloid" % "3.4-10"

scalacOptions in Compile += "-feature"

run <<= run in Android

install <<= install in Android

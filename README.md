[![](https://jitpack.io/v/Vechktor/JTag.svg)](https://jitpack.io/#Vechktor/JTag)
[![Vechktor](https://circleci.com/gh/Vechktor/JTag.svg?style=svg)]()
[![GitHub release](https://img.shields.io/github/release/Naereen/StrapDown.js.svg)](https://github.com/Vechktor/JTag/releases/)

# JTag
------------------------------

## What is JTag

JTag is simple API for reading & writing Named Binary Tag (NBT) based on JNBT.

## How to use it

JTag provides several classes and APIs for that purposes.
Highly recommended to use [NBTInputStream](https://github.com/Vechktor/JTag/) for reading
and [NBTOutputStream](https://github.com/Vechktor/JTag/)

```java
NBTInputStream stream = new NBTInputStream(/** some data here... */);
/**
 * read from stream some data
 */
stream.close();
```
And
```java
NBTOutputStream stream = new NBTOutputStream(/** some data here... */);
/**
 * write to stream some data
 */
stream.close();
```

## Tags

Currently, library supports every modern type of tag. Tags implemented
using type inference and diamond operator. So, you do not need to use
lot of instances and types!

Simply define tag of Integer type. (Library doesn't support primitives!).
```java
// This will create tag with name "my_shiny_tags_name" and value of 10
ITag<Integer> intTag = new ITag<Integer>("my_shiny_tags_name", 10);
```

To get preferred supported type of tag, you can use utility & constants.
This example shows you, how to get Integer type.
```java
NBTUtil.getTypeById(NBTConst.getTypeInt());
```

## Contribute

You can contribute this library with pull requests
and issues.

## Thanks

Thanks to JNBT by Ancient (updates by Morlok8k), Mojang for Minecraft & NBT,
CircleCI for tests and development, Jitpack.io for flexible repository.

## Building

You can build this using
```shell
./gradlew assemble
```

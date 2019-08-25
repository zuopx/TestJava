# Spring Framework

## Annotation-based Wire

@Required is deprecated.

### @Autowired

for setter: autowire by type

for field: no need having setter, autowire by type

for constructor: autowire by type

@Autowired(required=false): autowiring is not necessary

### Annotation Configuration

use configuration class replace xml configuration

@Configuration

@Import(...)

@Bean(...)

## Event

事件处理的逻辑:
有点类似与异常的处理.
事件是一个对象,必须继承事件类,可以发布和捕获处理.一般由publisher(可接受一个context字段)抛出,需实现发布接口;由hander处理,hander需要实现侦听接口.

## AOP

# Summary

The goal of the RSocket TCK is to allow developers implement RSocket protocol in
their favoured programming language and be sure, that it follows RSocket 
specification.

#Motivation

Reactive programming is becoming popular since 2015. That year, the design of 
RSocket protocol had been started. Protocol pushes reactive semantic to the
network. Lots of engineers worked on implementations of RSocket protocol in 
different language. There is no way to check if implementation is compliant with
protocol specification.

# Detailed Design

To address issues that implementations were compliant with protocol 
specification we have to introduce a tool (TCK). TCK should use black-box 
testing against different implementations.

## Testing network communication

As RSocket implementation is a library that allows two applications talk to each
other reactively over the network TCK should support both `client` and `server`
compatibility tests. For that reason TCK should be a separate application that
can be run either as RSocket `client` or as RSocket `server`.

## Tests as specification

TCK should provide `DSL` language to allow programmatically describe cases from
protocol specification. Each case should have separate code section that allow
to validate an implementation in full and in case by case scenarios. Convenient 
`dsl` also allows describing specification in more precise way and catch any 
issues in specification itself.

## Test Reports

As the main goal of TCK development is to help engineers in implementing RSocket
protocol, the most critical feature of TCK is to well described reports on
which specification sections an implementation is not covering. Reports should
contain information about failures of not following the specification (e.g. 
precise frames ordering and format if states otherwise in spec)
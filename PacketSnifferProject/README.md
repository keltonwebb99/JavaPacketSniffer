# Overview

As a software engineer, my objective for this self-assigned project was to gain a comprehensive understanding of how to utilize Java in the realm of networking. With the intention of learning this language, I believed that setting a goal to work towards would enable me to fully engage with the programming concepts and techniques involved. This project has been instrumental in not only facilitating my understanding of Java, but also providing me with insight into how it can be utilized in the industry that I aspire to be a part of.

This project is a Java-Based network traffic analyzer that captures and analyzes network traffic. It uses the Pcap4j library, which is a packet capture tool that captures the packets and can analzyse them to provide useful information about network traffic.

The Packet Sniffer is a console-based Java application that provides users a friendly interface for capturing and analyzing network traffic. It prompts the user to select a network interface from a list of available interfaces, then captures packets from the selected interface. The captured packets are then displayed in the console as a Hex stream. The user can then copy and paste the Hex stream into a tool like wireshark to view the packet details. 

[Software Demo Video](https://youtu.be/tvucj_HLhVE)

# Development Environment

This project is written in Java, using Visual Stuidio Code IDE. The Pcap4j library is used for capturing and analyzing network packets. I used JDK 19 to run the project. 


Tools and Libraries Used:

- Java programming language
- Pcap4j library 
- An IDE of your choice
- Wireshark (for analyzing captured packets)


# Useful Websites

- [Pcap4j](https://www.pcap4j.org/)
- [Java Syntax](https://www.w3schools.com/java/java_syntax.asp)


# Future Work

- Elaborate on the captured packets with advanced information
- Create an interface that doesn't need to run from console
- Make a feature that exports captured packets to popular file formats like PCAP or CSV for further analysis
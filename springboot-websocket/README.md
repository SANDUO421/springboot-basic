## springboot+websocket 实战

### WHAT :明确概念
```markdown
1. WebSocket是一种在单个TCP连接上进行全双工通信的协议。
2. WebSocket通信协议于2011年被IETF定为标准RFC 6455，并由RFC7936补充规范。
3. WebSocket API也被W3C定为标准。
4. WebSocket使得客户端和服务器之间的数据交换变得更加简单，允许服务端主动向客户端推送数据。
5. 在WebSocket API中，浏览器和服务器只需要完成一次握手，两者之间就直接可以创建持久性的连接，并进行双向数据传输。

```
### WHY：明确原因
```markdown
优点：
    1、较少的控制开销。在连接创建后，服务器和客户端之间交换数据时，用于协议控制的数据包头部相对较小。在不包含扩展的情况下，对于服务器到客户端的内容，
        此头部大小只有2至10字节（和数据包长度有关）；
        对于客户端到服务器的内容，此头部还需要加上额外的4字节的掩码。相对于HTTP请求每次都要携带完整的头部，此项开销显著减少了。
    2、更强的实时性。由于协议是全双工的，所以服务器可以随时主动给客户端下发数据。相对于HTTP请求需要等待客户端发起请求服务端才能响应，延迟明显更少；
        即使是和Comet等类似的长轮询比较，其也能在短时间内更多次地传递数据。
    3、保持连接状态。与HTTP不同的是，Websocket需要先创建连接，这就使得其成为一种有状态的协议，之后通信时可以省略部分状态信息。
        而HTTP请求可能需要在每个请求都携带状态信息（如身份认证等）。
    4、更好的二进制支持。Websocket定义了二进制帧，相对HTTP，可以更轻松地处理二进制内容。
    5、可以支持扩展。Websocket定义了扩展，用户可以扩展协议、实现部分自定义的子协议。如部分浏览器支持压缩等。
    6、更好的压缩效果。相对于HTTP压缩，Websocket在适当的扩展支持下，可以沿用之前内容的上下文，在传递类似的数据时，可以显著地提高压缩率。
```
### WHO: 明确目标
```markdown
  长连接，解决消息推送
```
### WHERE: 明确位置
```markdown
    频繁请求，实时数据更新
```
### WHEN: 明确场景
    数据实时性要求高的场景
### HOW: 入门
    1. [SpringBoot2.0集成WebSocket，实现后台向前端推送信息](https://blog.csdn.net/moshowgame/article/details/80275084)
### 参考
1. [WebSocket 教程-阮一峰](http://www.ruanyifeng.com/blog/2017/05/websocket.html)
2. [SpringBoot2.0整合WebSocket，实现后端数据实时推送！](https://zhuanlan.zhihu.com/p/93694533)
3. [websocket-API](https://developer.mozilla.org/en-US/docs/Web/API/WebSocket)



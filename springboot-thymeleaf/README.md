## springboot+thymeleaf 实战

### WHAT :明确概念
```markdown
1. Thymeleaf是适用于Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。
2. Thymeleaf的主要目标是提供一种优雅且高度可维护的模板创建方式。为此，它以自然模板的概念为基础，以不影响模板用作
    设计原型的方式将其逻辑注入模板文件。这样可以改善设计沟通，并缩小设计团队与开发团队之间的差距。
3. Thymeleaf也已经从一开始就设计了Web标准记-尤其是HTML5 -如果你需要，允许您创建充分验证模板。
```
### WHY：明确原因
```markdown
模板即原型，前后端分离。
    缺点：
        效率不是最好的，甚至算差的。
    优点：
        Thymeleaf最大的特点是能够直接在浏览器中打开并正确显示模板页面，而不需要启动整个Web应用
        采用标签属性来进行模板的定义，没有破坏基本的html文档结构，这样就可以直接在浏览器中打开查看布局效果。
        也为前后端的分离开发奠定基础。
        后端人员熟悉后，可以前后端贯通开发。
```
### WHO: 明确目标
```markdown
    1. Thymeleaf的使用是由两部分组成的：标签 + 表达式，标签是Thymeleaf的语法结构，而表达式就是语法里的内容实现。
       通过标签 + 表达式，让数据和模板结合，最终转换成html代码，返回给用户
    2.  
```
### WHERE: 明确位置
```markdown
    html : resources/templates/*.html
   静态页面: resources/static/*.html
        resources/js/*.js
```
### WHEN: 明确场景
    模板，
### HOW: 入门
Springboot结合jpa加Thymeleaf显现一个简单的curd。

### 参考
1. [SpringBoot页面展示Thymeleaf](jianshu.com/p/a842e5b5012e)
2. [什么是Thymeleaf](https://www.jianshu.com/p/84a25d699cf5)


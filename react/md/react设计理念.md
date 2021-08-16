## 异步可中断
+ **react15为何慢**
react 15之前协调过程是同步的，js的执行是单线程，不能及时响应高优先级任务，如：用户输入等；表现出来就是页面的卡顿。

+ **解决方案 （异步可中断）**
任务分割、允许中断、在其他任务到来时让出执行权、当其他任务执行后从中断的部分开始异步执行剩下的计算。

+ **实现**
  任务分割、异步执行、让出执行权，带出react中的三个概念

  1. Fiber：react15 更新是同步的，因为他不能将任务分割需要一套数据结构让他既能对应真实dom又能作为分割单元，这就是Fiber
  2. Scheduler: 时间片运行机制，替代requestIdleCallback（浏览器兼容性，触发不稳定）
  3. Lane：管理各个任务优先级

``` javaScript
let firstFiber
let nextFiber = firstFiber
let shouldYield = false //标记

// firstFiber->firstChild->sibling

function performUnitOfWork(nextFiber){ // 处理节点
  //...
  return nextFiber.next
}

function workLoop(deadline){
  while(nextFiber && !shouldYield){
        nextFiber = performUnitOfWork(nextFiber)
        shouldYield = deadLine.timeReaming < 1 //判断当前闲置周期剩余时间
  }
  requestIdleCallback(workLoop)
}

requestIdleCallback(workLoop)
```


+ **产生出来的上层实现**

  通过异步可中断机制我们就能实现batchedUpdates批量更新和Suspense
  
+ **代数效应**

  

# ComposeDaily——007

## 修饰符
借助修饰符，您可以修饰或扩充可组合项。您可以使用修饰符来执行以下操作：

* 更改可组合项的大小、布局、行为和外观
* 添加信息，如无障碍标签
* 处理用户输入
* 添加高级互动，如使元素可点击、可滚动、可拖动或可缩放

```kotlin
@Composable
fun ColumnMultipleText() {
    Column(
        modifier = Modifier.padding(24.dp),
        //垂直方向居中
        verticalArrangement = Arrangement.Center,
        //水平方向靠右
        horizontalAlignment = Alignment.End
    ){
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
```
同时也可以将多个修饰符函数链式调用：

```kotlin
@Composable
fun ColumnMultipleText() {
    Column(
        modifier = Modifier.padding(24.dp)
            .fillMaxWidth(),
        //垂直方向居中
        verticalArrangement = Arrangement.Center,
        //水平方向靠右
        horizontalAlignment = Alignment.End
    ){
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
```
请注意，在上面的代码中，结合使用了不同的修饰符函数。

* padding 在元素周围留出空间。
* fillMaxWidth 使可组合项填充其父项为它提供的最大宽度。

最佳做法是让所有可组合项接受 modifier 参数，并将该修饰符传递给其发出界面元素的第一个子项。这样做可以提高代码的可重用性，使其行为更可预测且更直观。

[官方文档](https://developer.android.com/jetpack/compose/modifiers)

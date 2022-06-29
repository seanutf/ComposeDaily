# ComposeDaily——006

## 布局
在View系统中，我们创建一个XML布局文件时，Android Studio会默认帮我们添加上顶层父布局。
而在Jetpack Compose中，默认是没有添加父布局层级的，并且相比于View系统中，不同层级、不同实现的ViewGroup
Jetpack Compose中布局种类很少：

## Column
就如同Column这个单词的翻译一样，在Column中就是表示子组件是纵向竖直排列：

```kotlin
@Composable
fun ColumnMultipleText() {
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
```

## Row
Row则表示子组件是横向水平排列：

```kotlin
@Composable
fun RowMultipleText() {
    Row{
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
```

Column和Row都支持设置子组件在排列时的对齐方式：
```kotlin
@Composable
fun RowMultipleText(artist: Artist) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
```

## Box 
使用Box可将元素放在其他元素上：

```kotlin
@Composable
fun BoxMultipleText(artist: Artist) {
    Box(verticalAlignment = Alignment.CenterVertically) {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}
```

## 布局模型

[官方文档](https://developer.android.com/jetpack/compose/layouts/basics#model)


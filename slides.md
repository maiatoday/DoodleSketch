---
layout: cover
background: https://source.unsplash.com/1600x900/?nature,water
title: Slidev
---

# Doodle Sketch

@maiatoday
<style>
    img {
        border-radius: 50%;
    }
</style>
<img src="https://maiatoday.net/maiaSquare.jpeg" class="m-10 h-30" />


---

# Page 2

Directly use code blocks for highlighting

```kotlin {2,3|all} {lines:true}
fun main() = application {
    Window(
        title = "Doodle Sketch Blue Blocks",
        state = rememberWindowState(width = 990.dp, height = 990.dp),
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        DoodlingBlueBlocks()
    }
}
```
<!-- This is a note -->

---
layout: two-cols
---

<template v-slot:default>

# Left

This shows on the left
![oo](bezier.jpg)

</template>
<template v-slot:right>

# Right

This shows on the right

<v-clicks>

* ine
* blargh
* gafluey
* sznork
* barugh
</v-clicks>

</template>

<!--
This is another note
-->

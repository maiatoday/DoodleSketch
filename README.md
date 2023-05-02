### Jetpack Compose  
# DoodleSketch

Experiments in doodling in compose. The drawing part works equally well in Android and in desktop compose. To see the previews you need the [Compose Multiplatform plugin](https://plugins.jetbrains.com/plugin/16541-compose-multiplatform-ide-support)
When was the last time you just experimented with pens and paper just drawing for fun and not for any specific reason.


![](images/BeSquare.jpg)

![](images/Heart.jpg)

![](images/Dotty.jpg)

---
# BeSquare

Exploring the Canvas coordinate system by drawing squares. The coordinate system looks like this:

![](images/coordinates.jpg)

---
## Dotty


![](images/Dotty.jpg)

Circles filled and empty. Ellipses and ovals.
---
## LotsOfLines
The coordinate system again. 
### A line has two ends and a thickness.

![](images/LotsOfLines.jpg)


---
## MyBrush


![](images/MyBrushes.jpg)

Gradients in all directions
---
## SweetPath cubicTo

---
![](images/bezier.jpg)
---

![](images/JoinTheDots.jpg)

Join the dots. Bezier curves. Translations and rotations. Here is a [site](http://blogs.sitepointstatic.com/examples/tech/canvas-curves/bezier-curve.html)
that shows how the `cubicTo` method works. Also some animations.
---
## Sample - mobile and desktop

---
### What's the difference between _mobile_ and _desktop_

Desktop has:

- Window
- Toolbar
- Notifications
- Mouse clicks/drags/moves
- Lifecycle is simple

Mobile has:

- Complex lifecycle
- Back button
- Touch gestures
- Android system interactions

The drawing part is almost identical between Desktop and Android.

---

![](images/sadhearts_desktop.png)


![](images/sadhearts_mobile.png)

---

![](images/happyhearts_desktop.png)


![](images/happyhearts_mobile.png)


---
## All the things and Choices

Setup some choices and draw from the choices. Drawing libraries typically have an area of code where you can initialise things and than an area of code or a method which draws repeatedly. In Compose if you want to update what is on the screen then you change the state. The core mechanism that compose has is that the Composer will recompose the `@Composable` functions if the state changes. So in this final example if the `Choices` are modified or the random points change, all the composables will be called again and redraw.
---


![](images/DoodleSketch.png)
---
### www.github.com/maiatoday/DoodleSketch

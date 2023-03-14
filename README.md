# Desktop Compose Doodles

Experiments in doodling in compose

## BeSquare

Exploring rectangles and the coordinate system. The coordinate looks like this:
<image goes here>

## Dotty

Circles filled and empty. Ellipses and ovals.

## LotsOfLines

The coordinate system aagan. I line has two ends and a thickness.

## MyBrush

Gradients in all directions

## SweetPath

Join the dots. Bezier curves. Translations and rotations. Here is a site that shows how the `cubicTo` method works. Also some animations.

<image goes here

[http://blogs.sitepointstatic.com/examples/tech/canvas-curves/bezier-curve.html](http://blogs.sitepointstatic.com/examples/tech/canvas-curves/bezier-curve.html)

## Sample - mobile and desktop

What's the difference between mobile and desktop.

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

## All the things and Choices

Setup some choices and draw from the choices. Other libraries have an animation loop. Some for of setup and then something that loops and draws. You can build this in Compose. The core mechanism that compose has is that the Composer will recompose the `@Composable` functions if the state changes. So in this final example if the `Choices` are modified or the random points change, all the composables will be called again and redraw.

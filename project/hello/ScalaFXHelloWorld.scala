package hello

import scalafx.application.{JFXApp, JFXApp3}
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{HBox, Pane}
import scalafx.scene.paint.*
import scalafx.scene.paint.Color.*
import scalafx.scene.text.Text

import scala.language.implicitConversions

def renderCanvas(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Set the background color
  graphicsContext.setFill(Color.LightGray)
  graphicsContext.fillRect(0, 0, 800, 800)

  // Main Outer Outline
  graphicsContext.setStroke(Color.Gray)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(100, 100, 600, 600)
  // Main Inner Outline
  graphicsContext.setStroke(Color.BLACK)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(120, 120, 560, 560)

  // Coloring The Middle Space
//  graphicsContext.setFill(Color.Red)
//  graphicsContext.fillRect(130, 130, 540, 540)
}

def home(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.White)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(280, 280, 200, 200)

  // Inner Line
  graphicsContext.setStroke(Color.White)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(320, 320, 120, 120)

  // Coloring Middle Space Black
  graphicsContext.setFill(Color.White)
  graphicsContext.fillRect(330, 330, 100, 100)

  // Printing The Text 'HOME'
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.setFont(javafx.scene.text.Font.font("Arial", 20))
  graphicsContext.fillText("HOME", 335, 365)
}

def renderCircle(graphicsContext: GraphicsContext, color: Color, x: Int, y: Int, size: Int, outline: Boolean): Unit = {
  if(!outline){
    graphicsContext.setFill(color)
    graphicsContext.fillOval(x, y, size, size)
  } else {
    graphicsContext.setStroke(color)
    graphicsContext.setLineWidth(3);
    val outlineSize = size + (10 * 2)
    graphicsContext.strokeOval(x-10, y-10, outlineSize, outlineSize);
  }

}
def drawCorner(canvas: Canvas, x: Int, y: Int, color: Color): Unit = {
  val graphicsContext = canvas.graphicsContext2D;

  //outline
  renderCircle(graphicsContext, Color.Black, x, y, 100, true)

  var changedX = x + 15
  var changedY = y + 15
  //filled circles
  renderCircle(graphicsContext, color, changedX, changedY, 30, false)
  renderCircle(graphicsContext, color, changedX, changedY  + 40, 30, false)
  renderCircle(graphicsContext, color, changedX + 40, changedY, 30, false)
  renderCircle(graphicsContext, color, changedX + 40, changedY + 40, 30, false)



}


object ScalaFXHelloWorld extends JFXApp3:

  override def start(): Unit =

    //    stage = new JFXApp3.PrimaryStage :
    //      //    initStyle(StageStyle.Unified)
    //      title = "ScalaFX Hello World"
    //      scene = new Scene :
    //        fill = Color.rgb(38, 38, 38)
    //        content = new HBox :
    //          padding = Insets(50, 80, 50, 80)
    //          children = Seq(
    //            new Text :
    //              text = "Scala"
    //              style = "-fx-font: normal bold 100pt sans-serif"
    //              fill = new LinearGradient(endX = 0, stops = Stops(Red, DarkRed))
    //            ,
    //            new Text :
    //              text = "FX"
    //              style = "-fx-font: italic bold 100pt sans-serif"
    //              fill = new LinearGradient(endX = 0, stops = Stops(White, DarkGray))
    //              effect = new DropShadow :
    //                color = DarkGray
    //                radius = 15
    //                spread = 0.25
    //          )
    val canvas = new Canvas(800, 800)
    renderCanvas(canvas)

    // Wrap the Canvas in a Pane
    val rootPane = new Pane {
      children = canvas
    }

  // Create the main window
    stage = new JFXApp3.PrimaryStage {
      title = "Ludo Game"
      scene = new Scene(800, 800) {
        root = rootPane
      }
  }


    //top corners
    drawCorner(canvas, 150, 150, Color.Green)
    drawCorner(canvas, 550, 150, Color.Blue)


    //bottom corners
    drawCorner(canvas, 150, 550, Color.Red)
    drawCorner(canvas, 550, 550, Color.Yellow)

    //Prvi red ploče ili gornji dio iznad kruga

    renderCircle(canvas.graphicsContext2D,Color.Green,280,150,15,true) // zeleni kružić kod kućice :D
    renderCircle(canvas.graphicsContext2D, Color.Black,360, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Green,400, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black,440, 150, 15, true)
    renderCircle(canvas.graphicsContext2D,Color.Black, 480, 150,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black, 320, 150,15,true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 520, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black,560, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 600, 150, 15, true)


    //Drugi red

    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 200, 15, true)



    //Treći red

    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 250, 15, true)


    //Četvrti red

    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 300, 15, true)






    renderCircle(canvas.graphicsContext2D, Color.Black, 381,350, 65, true)

    // Iza kruga donji dio


    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 450, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 500, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 550, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 600, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Yellow, 400, 650, 15, true)

    // right flank

    renderCircle(canvas.graphicsContext2D, Color.Black, 470, 370, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 505, 370, 15, true) // dodajemo na x parametar 35 , a y ostaje isti / fixan
    renderCircle(canvas.graphicsContext2D, Color.Black, 540, 370, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 575, 370, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 610, 370, 15, true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,370,15,true)

    // left flank
    //renderCircle(canvas.graphicsContext2D,Color.Red,135,370,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,170,370,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,205,370,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,240,370,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,275,370,15,true)   // dodajemo na x parametar 35 , a y ostaje isti / fixan
    renderCircle(canvas.graphicsContext2D,Color.Black,310,370,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,345,370,15,true)

    // desna vertikala

    renderCircle(canvas.graphicsContext2D,Color.Black,645,160,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,195,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,230,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,265,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,300,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,335,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Blue,645,370,15,true) // x ostaje isti , a y dodajmo 35
    renderCircle(canvas.graphicsContext2D,Color.Black,645,405,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,440,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,475,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,475,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,510,15,true)
    /*renderCircle(canvas.graphicsContext2D,Color.Black,645,545,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,580,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,615,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,645,650,15,true)*/

    //lijeva vertikala


    renderCircle(canvas.graphicsContext2D,Color.Black,135,140,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,185,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,240,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,285,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,330,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Red,135,370,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,415,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,470,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,525,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,580,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,640,15,true)
    /*renderCircle(canvas.graphicsContext2D,Color.Black,135,540,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,575,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,610,15,true)
    renderCircle(canvas.graphicsContext2D,Color.Black,135,645,15,true)*/

    // donji dio

    renderCircle(canvas.graphicsContext2D, Color.Black, 160, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 200, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 240, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 280, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 320, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 360, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 440, 650, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 480, 650, 15, true)
























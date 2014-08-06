package net.ggkx.surface

import org.scaloid.common._
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style
import android.view.SurfaceHolder
import android.view.SurfaceView

class MainActivity extends SActivity with SurfaceHolder.Callback {
  private var holder: SurfaceHolder = null
  private val surfaceID = 100
  onCreate {
    contentView = new SVerticalLayout {
      SSurfaceView() id(surfaceID) minimumWidth(200) minimumHeight(400)
    } padding 10.dip

    holder = find(surfaceID).asInstanceOf[SSurfaceView].getHolder()
    holder.addCallback(this)
  }
  private val fps = 20
  private val frame_consume = 1000 /fps
  override def surfaceCreated(holder:SurfaceHolder){
    var canvas = holder.lockCanvas()
    canvas.drawColor(Color.WHITE)
    var paint = new Paint(Paint.ANTI_ALIAS_FLAG)
    paint.setColor(Color.BLUE)
    paint.setStyle(Style.FILL)
    canvas.drawCircle(100,200,50,paint)
    holder.unlockCanvasAndPost(canvas)
  }
  override def surfaceChanged(holder:SurfaceHolder,format:Int, width:Int,height:Int){}
  override def surfaceDestroyed(holder:SurfaceHolder){}
}

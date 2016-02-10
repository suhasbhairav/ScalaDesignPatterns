import javax.swing.ImageIcon
import java.net.URL


trait Proxy

trait Service

trait ImageProvider{
  val fileUrl : URL
  def image : ImageIcon

}

private class RealImageService(val fileUrl: URL) extends Service with ImageProvider{
    private val imageIcon = new ImageIcon(fileUrl)
    def image: ImageIcon = imageIcon

}

class ImageServiceProxy(imageFileURL : URL) extends Proxy with ImageProvider{
    val fileURL = imageFileURL
    //Using the lazy object, we can defer the full cost of initialization
    private lazy val imageService = new RealImageService(imageFileURL)
    def image : ImageIcon = imageService.image
    override def toString = "ImageServiceProxy for:"+imageFileURL.toString()

}

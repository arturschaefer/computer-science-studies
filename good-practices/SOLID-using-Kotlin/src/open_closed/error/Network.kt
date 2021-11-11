package open_closed.error

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class Network {
    private val uri = URI("https://www.ford.com/cars/mustang") //this link is random, but in the real world would be a valid URI

    fun postMessage(message: String) {
        val httpClient = HttpClient.newHttpClient()
        val body = HttpRequest.BodyPublishers.ofString(message)
        val request = HttpRequest.newBuilder(uri).POST(body).build()
        httpClient.send(request, HttpResponse.BodyHandlers.discarding())
    }
}
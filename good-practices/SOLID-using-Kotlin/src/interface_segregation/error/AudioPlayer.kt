package interface_segregation.error

class AudioPlayer: Player {
    override fun play() {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun startVideo() {
       //Error: there is no video to this type of player; This is a violation of the interface. Because the method haven't a implementation
    }
}
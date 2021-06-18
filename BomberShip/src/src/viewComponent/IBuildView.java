package viewComponent;

import java.awt.Component;

import javax.swing.JPanel; 
import marComponent.Mar.IMarVisual; 

public interface IBuildView {

	public Component criaPlayerView(JPanel playerView, JPanel itensPlayerView, String Player, IMarVisual mar) ;

}

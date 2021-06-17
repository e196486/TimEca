package viewComponent;

import java.awt.Component;

import javax.swing.JPanel;

import marComponent.Mar.IBuildMar;
import marComponent.Mar.Mar;

public interface IBuildView {

	public Component criaPlayerView(JPanel playerView, JPanel itensPlayerView, String Player, IBuildMar mar) ;

}

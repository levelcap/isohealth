/****************************************************************************
 * Copyright (c) 1998-2010 AOL Inc. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ****************************************************************************/
package org.apache.jmeter.protocol.oauth.control.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.protocol.oauth.sampler.OAuthSampler;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.BooleanProperty;
import org.apache.jorphan.gui.JLabeledChoice;


/**
 * Basic OAuth configuration:
 * - Consumer key
 * - Signing method, secret or private key
 * - token, token secret
 * - Use Authorization header
 */
public class OAuthConfigGui extends JPanel implements ChangeListener {

	public static final long serialVersionUID = 1L;

	private JTextField key;

	private JTextField secret;

	private JCheckBox useAuthHeader;
	
	private JCheckBox urlEncode;
	
	private JLabeledChoice signatureMethod;
	
	private JTextField token;

	private JTextField tokenSecret;
	
	private JLabel secretLabel;
	
	private GridBagConstraints fixedConstraints;

	private GridBagConstraints stretchyConstraints;
        
	public OAuthConfigGui() {
			init();
	}
	
	protected void configureTestElement(TestElement mc) {
		mc.setName(getName());
		mc.setProperty(TestElement.GUI_CLASS, this.getClass().getName());
		mc.setProperty(TestElement.TEST_CLASS, mc.getClass().getName());
	}

	public void clear() {
		key.setText(""); //$NON-NLS-1$
		useAuthHeader.setSelected(false);
		urlEncode.setSelected(false);
		signatureMethod.setText(OAuthSampler.DEFAULT_METHOD);
		secret.setText(""); //$NON-NLS-1$
		token.setText(""); //$NON-NLS-1$
		tokenSecret.setText(""); //$NON-NLS-1$
	}

	public TestElement createTestElement() {
		ConfigTestElement element = new ConfigTestElement();

		this.configureTestElement(element);
		modifyTestElement(element);
		return element;
    }

	/**
	 * Save the GUI values in the sampler.
	 * 
	 * @param element
	 */
    public void modifyTestElement(TestElement element) {
    	element.setProperty(OAuthSampler.KEY, key.getText());
		element.setProperty(new BooleanProperty(
				OAuthSampler.USE_AUTH_HEADER, useAuthHeader.isSelected()));
		element.setProperty(new BooleanProperty(
				OAuthSampler.URL_ENCODE, urlEncode.isSelected()));
		element.setProperty(OAuthSampler.SIGNATURE_METHOD, signatureMethod.getText());
    	element.setProperty(OAuthSampler.SECRET, secret.getText());
    	element.setProperty(OAuthSampler.TOKEN, token.getText());
    	element.setProperty(OAuthSampler.TOKEN_SECRET, tokenSecret.getText());

	}

	/**
	 * Set the text, etc. in the UI.
	 * 
	 * @param el
	 *            contains the data to be displayed
	 */
	public void configure(TestElement el) {
		setName(el.getName());

		key.setText(el.getPropertyAsString(OAuthSampler.KEY));
		useAuthHeader.setSelected(((AbstractTestElement) el).
				getPropertyAsBoolean(OAuthSampler.USE_AUTH_HEADER));
		urlEncode.setSelected(((AbstractTestElement) el).
				getPropertyAsBoolean(OAuthSampler.URL_ENCODE));
		signatureMethod.setText(
				el.getPropertyAsString(OAuthSampler.SIGNATURE_METHOD));
		secret.setText(el.getPropertyAsString(OAuthSampler.SECRET));
		token.setText(el.getPropertyAsString(OAuthSampler.TOKEN));
		tokenSecret.setText(el.getPropertyAsString(OAuthSampler.TOKEN_SECRET));	
	}

	private void init() {// called from ctor, so must not be overridable
		this.setLayout(new BorderLayout());

		// OAuth parameters panel
		JPanel oauthPanel = new VerticalPanel();
		oauthPanel.setLayout(new BoxLayout(oauthPanel, BoxLayout.Y_AXIS));
		oauthPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				OAuthSamplerGui.getResString("oauth_param"))); //$NON-NLS-1$
		
		createConstraints();
		
		oauthPanel.add(getConsumerKeyPanel());
		oauthPanel.add(getConsumerSecretPanel());
		oauthPanel.add(getTokenPanel());

		this.add(oauthPanel);
	}

	/**
	 * Consumer key panel contains
	 * 
	 *    Consumer key
	 *    Use Auth Header?
	 *    Encode?
	 * @return
	 */
	protected JPanel getConsumerKeyPanel() {
		// Consumer key
		key = new JTextField(15);
		key.setName(OAuthSampler.KEY);
		JLabel keyLabel = new JLabel(OAuthSamplerGui.getResString("oauth_consumer_key")); //$NON-NLS-1$
		keyLabel.setLabelFor(key);

		// Use Auth Header
		useAuthHeader = new JCheckBox(
				OAuthSamplerGui.getResString("oauth_use_auth_header")); //$NON-NLS-1$
		useAuthHeader.setName(OAuthSampler.USE_AUTH_HEADER);
		useAuthHeader.setSelected(false);
	
		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(keyLabel, fixedConstraints);
        panel.add(key, stretchyConstraints);
        panel.add(useAuthHeader, fixedConstraints);
		
		return panel;
	}

	
	/**
	 * Secret panel contains
	 * 
	 *    Signature method
	 *    Consumer secret or key
	 *    
	 * @return
	 */
	protected JPanel getConsumerSecretPanel() {

       	signatureMethod = new JLabeledChoice(OAuthSamplerGui.getResString("oauth_signature_method"), //$NON-NLS-1$
                OAuthSampler.METHODS);
       	signatureMethod.addChangeListener(this);

		secret = new JTextField(20);
		secret.setName(OAuthSampler.SECRET);
		
		secretLabel = new JLabel(OAuthSamplerGui.getResString("oauth_consumer_secret")); //$NON-NLS-1$
		secretLabel.setLabelFor(secret);
   
        JPanel panel = new JPanel(new GridBagLayout());
        
        panel.add(secretLabel, fixedConstraints);
		panel.add(secret, stretchyConstraints);
		panel.add(signatureMethod, fixedConstraints);
		
		return panel;
	}

	/**
	 * Token panel contains
	 * 
	 *    Token
	 *    Token secret
	 *    
	 * @return
	 */
	protected JPanel getTokenPanel() {

		// Token
		token = new JTextField(20);
		token.setName(OAuthSampler.TOKEN);
		
		JLabel tokenLabel = new JLabel(OAuthSamplerGui.getResString("oauth_token")); //$NON-NLS-1$
		tokenLabel.setLabelFor(token);

		// Token secret
		tokenSecret = new JTextField(20);
		tokenSecret.setName(OAuthSampler.TOKEN_SECRET);
		
		JLabel tokenSecretLabel = new JLabel(OAuthSamplerGui.getResString("oauth_token_secret")); //$NON-NLS-1$
		tokenSecretLabel.setLabelFor(tokenSecret);
	
		// Url Encode?
		urlEncode = new JCheckBox(
				OAuthSamplerGui.getResString("oauth_url_encode")); //$NON-NLS-1$
		urlEncode.setName(OAuthSampler.URL_ENCODE);
		urlEncode.setSelected(false);

		VerticalPanel tokenPanel = new VerticalPanel();
		tokenPanel.add(tokenLabel, BorderLayout.WEST);
		tokenPanel.add(token, BorderLayout.CENTER);
		
		VerticalPanel secretPanel = new VerticalPanel();
		secretPanel.add(tokenSecretLabel, BorderLayout.WEST);
		secretPanel.add(tokenSecret, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel(new GridBagLayout());
		leftPanel.add(tokenPanel, stretchyConstraints);
		leftPanel.add(secretPanel, stretchyConstraints);
		
		JPanel panel = new VerticalPanel();
		panel.add(leftPanel, BorderLayout.CENTER);
		panel.add(urlEncode, BorderLayout.EAST);
		
		return panel;
	}


	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == signatureMethod){
			if (signatureMethod.getText().equals(OAuthSampler.HMAC)) {
				secretLabel.setText(OAuthSamplerGui.getResString("oauth_consumer_secret")); //$NON-NLS-1$
			} else {
				secretLabel.setText(OAuthSamplerGui.getResString("oauth_private_key")); //$NON-NLS-1$
			}
		}

	}
	
	/**
	 * The constraints used by GridBagLayout manager.
	 */
    private void createConstraints() {
    	
        fixedConstraints = new GridBagConstraints();
        fixedConstraints.anchor = GridBagConstraints.CENTER;
        fixedConstraints.insets = new Insets(1, 1, 1, 1);
        fixedConstraints.weightx = 0.0;
        fixedConstraints.gridwidth = 1;
        fixedConstraints.gridx = GridBagConstraints.RELATIVE;
        fixedConstraints.gridy = 0;

        stretchyConstraints = (GridBagConstraints)fixedConstraints.clone();
        stretchyConstraints.fill = GridBagConstraints.HORIZONTAL;
        stretchyConstraints.weightx = 1.0;
        stretchyConstraints.gridwidth = GridBagConstraints.RELATIVE;
   
    }
}

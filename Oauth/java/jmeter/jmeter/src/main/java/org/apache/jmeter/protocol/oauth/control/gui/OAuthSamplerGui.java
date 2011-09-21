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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;
import org.apache.jmeter.protocol.http.config.gui.UrlConfigGui;
import org.apache.jmeter.protocol.oauth.sampler.OAuthSampler;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.gui.JLabeledTextField;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;


//For unit tests, @see TestHttpTestSampleGui

/**
 * HTTP Sampler GUI
 * 
 */
public class OAuthSamplerGui extends AbstractSamplerGui {

	public static final String PROP_BASENAME = 
		"org.apache.jmeter.protocol.oauth.resources.messages"; //$NON-NLS-1$
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggingManager.getLoggerForClass();
	
	private OAuthConfigGui oauthConfigGui;

	private UrlConfigGui urlConfigGui;

	private JCheckBox getImages;

	private JCheckBox isMon;

    private JCheckBox useMD5;

    private JLabeledTextField embeddedRE; // regular expression used to match against embedded resource URLs
	
	private static ResourceBundle resources;
	
	public OAuthSamplerGui() {
		init();
	}

	public void configure(TestElement element) {
		super.configure(element);
        final HTTPSamplerBase samplerBase = (HTTPSamplerBase) element;
        oauthConfigGui.configure(element);
		urlConfigGui.configure(element);
		getImages.setSelected(samplerBase.isImageParser());
		isMon.setSelected(samplerBase.isMonitor());
        useMD5.setSelected(samplerBase.useMD5());
		embeddedRE.setText(samplerBase.getEmbeddedUrlRE());
	}

	public TestElement createTestElement() {
		HTTPSamplerBase sampler = new OAuthSampler();
		modifyTestElement(sampler);
		return sampler;
	}

	/**
	 * Modifies a given TestElement to mirror the data in the gui components.
	 * 
	 * @see org.apache.jmeter.gui.JMeterGUIComponent#modifyTestElement(TestElement)
	 */
	public void modifyTestElement(TestElement sampler) {
		sampler.clear();
		oauthConfigGui.modifyTestElement(sampler);
        urlConfigGui.modifyTestElement(sampler);
		final HTTPSamplerBase samplerBase = (HTTPSamplerBase) sampler;
		if (getImages.isSelected()) {
			samplerBase.setImageParser(true);
		} else {
			// The default is false, so we can remove the property to simplify JMX files
			// This also allows HTTPDefaults to work for this checkbox
			sampler.removeProperty(HTTPSamplerBase.IMAGE_PARSER);
		}
		samplerBase.setMonitor(isMon.isSelected());
        samplerBase.setMD5(useMD5.isSelected());
		samplerBase.setEmbeddedUrlRE(embeddedRE.getText());
		this.configureTestElement(sampler);
	}

	public String getLabelResource() {
		throw new IllegalStateException("This shouldn't be called"); //$NON-NLS-1$
	}

	public String getStaticLabel() {
		return getResString("oauth_testing_title"); //$NON-NLS-1$
	}

	private void init() {// called from ctor, so must not be overridable
		setLayout(new GridBagLayout());
		setBorder(makeBorder());

		// Create constraints for 4 vertical component, give weight
		// to Url Config
	    GridBagConstraints c1 = new GridBagConstraints();
	    c1.gridx = 0;
	    c1.gridy = 0;
	    c1.fill = GridBagConstraints.HORIZONTAL;
	    c1.anchor = GridBagConstraints.CENTER;
	    c1.weightx = 1.0;
	    c1.weighty = 0.0;
	    c1.insets = new Insets(1, 1, 1, 1);
	    c1.gridwidth = GridBagConstraints.REMAINDER;
	    c1.gridheight = 1;

	    GridBagConstraints c2 = (GridBagConstraints)c1.clone();
	    c2.gridy = 1;
	    
	    GridBagConstraints c3 = (GridBagConstraints)c1.clone();
	    c3.gridy = 2;
	    c3.fill = GridBagConstraints.BOTH;
	    c3.weighty = 1.0;
	    c3.gridheight = GridBagConstraints.RELATIVE;
	    
	    GridBagConstraints c4 = (GridBagConstraints)c1.clone();
	    c4.gridy = 3;
	 
		add(makeTitlePanel(), c1);
		
		// OAuth
		oauthConfigGui = new OAuthConfigGui();
		add(oauthConfigGui, c2);

		// URL CONFIG
		urlConfigGui = new UrlConfigGui();
		add(urlConfigGui, c3);

		// OPTIONAL TASKS
		add(createOptionalTasksPanel(), c4);
	}

	private JPanel createOptionalTasksPanel() {
		// OPTIONAL TASKS
	    JPanel optionalTasksPanel = new VerticalPanel();
		optionalTasksPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				JMeterUtils.getResString("optional_tasks"))); //$NON-NLS-1$

		JPanel checkBoxPanel = new HorizontalPanel();
		// RETRIEVE IMAGES
		getImages = new JCheckBox(JMeterUtils.getResString("web_testing_retrieve_images")); //$NON-NLS-1$
		// Is monitor
		isMon = new JCheckBox(JMeterUtils.getResString("monitor_is_title")); //$NON-NLS-1$
        // Use MD5
        useMD5 = new JCheckBox(JMeterUtils.getResString("response_save_as_md5")); //$NON-NLS-1$

        checkBoxPanel.add(getImages);
		checkBoxPanel.add(isMon);
        checkBoxPanel.add(useMD5);
        optionalTasksPanel.add(checkBoxPanel);

		// Embedded URL match regex
		embeddedRE = new JLabeledTextField(JMeterUtils.getResString("web_testing_embedded_url_pattern"),30); //$NON-NLS-1$
		optionalTasksPanel.add(embeddedRE);
		return optionalTasksPanel;
	}

	public Dimension getPreferredSize() {
		return getMinimumSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.jmeter.gui.JMeterGUIComponent#clearGui()
	 */
	public void clearGui() {
		super.clearGui();
		getImages.setSelected(false);
		isMon.setSelected(false);
		useMD5.setSelected(false);
		urlConfigGui.clear();
		oauthConfigGui.clear();
		embeddedRE.setText(""); //$NON-NLS-1$
	}
	
	static {
		Locale loc = JMeterUtils.getLocale();
		resources = ResourceBundle.getBundle(PROP_BASENAME, loc);
		log.info("Resource " + PROP_BASENAME +  //$NON-NLS-1$
				" is loaded for locale " + loc); //$NON-NLS-1$
	}
	
	/**
	 * Gets the resource string for this key.
	 * 
	 * If the resource is not found, a warning is logged
	 * 
	 * @param key
	 *            the key in the resource file
	 * @return the resource string if the key is found; otherwise, return
	 *         "[res_key="+key+"]"
	 */
	public static String getResString(String key) {
		return getResStringDefault(key, RES_KEY_PFX + key + "]"); //$NON-NLS-1$
	}

	public static final String RES_KEY_PFX = "[res_key="; //$NON-NLS-1$

	/*
	 * Helper method to do the actual work of fetching resources; allows
	 * getResString(S,S) to be deprecated without affecting getResString(S);
	 */
	private static String getResStringDefault(String key, String defaultValue) {
		if (key == null) {
			return null;
		}
		// Resource keys cannot contain spaces
		key = key.replace(' ', '_'); // $NON-NLS-1$ // $NON-NLS-2$
		key = key.toLowerCase(java.util.Locale.ENGLISH);
		String resString = null;
		try {
			resString = resources.getString(key);
		} catch (MissingResourceException mre) {
			log.warn("ERROR! Resource string not found: [" +  //$NON-NLS-1$
					key + "]", mre); //$NON-NLS-1$
			resString = defaultValue;
		}
		return resString;
	}

}

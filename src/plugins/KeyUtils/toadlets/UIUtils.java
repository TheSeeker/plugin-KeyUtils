package plugins.KeyUtils.toadlets;

import java.util.List;

import freenet.clients.http.InfoboxNode;
import freenet.keys.FreenetURI;
import freenet.support.HTMLNode;
import freenet.support.plugins.helpers1.PluginContext;

public class UIUtils {

	public static HTMLNode createErrorBox(PluginContext pCtx, List<String> errors) {
		return createErrorBox(pCtx, errors, null, null, null);
	}

	public static HTMLNode createErrorBox(PluginContext pCtx, List<String> errors, String path, FreenetURI retryUri, String extraParams) {

		InfoboxNode box = pCtx.pageMaker.getInfobox("infobox-alert", "ERROR");
		HTMLNode errorBox = box.content;
		for (String error : errors) {
			errorBox.addChild("#", error);
			errorBox.addChild("br");
		}
		if (retryUri != null) {
			errorBox.addChild("#", "Retry: ");
			errorBox.addChild(new HTMLNode("a", "href", path + "?key="
					+ ((extraParams == null) ? retryUri : (retryUri + "?" + extraParams)), retryUri.toString(false, false)));
		}
		return box.outer;
	}

}
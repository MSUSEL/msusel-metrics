package edu.montana.gsoc.msusel.metrics

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.montana.gsoc.msusel.codetree.metrics.loc.UnknownProfileException

import java.lang.reflect.Type

@Singleton
class LoCProfileManager {

    static final String DEFAULT_LOCATION = "/edu/montana/gsoc/msusel/metrics/default.json"

    /**
     * Map of known profiles where the served extensions are the key
     */
    Map<String, LoCProfile> profileByExtension = [:]
    /**
     * Map of known profiles where the served language is the key
     */
    private Map<String, LoCProfile> profileByLanguage = [:]

    static { loadProfiles() }

    /**
     * Adds the given profile to this profile manager
     *
     * @param profile
     *            Profile to add
     */
    void addProfile(LoCProfile profile) {
        for (String ext : profile.getExtensions()) {
            profileByExtension.put(ext.toLowerCase(), profile)
        }

        profileByLanguage.put(profile.getLanguage().toLowerCase(), profile)
    }

    /**
     * Requests a profile for a given file extension (excluding the dot)
     *
     * @param ext
     *            File extension
     * @return The profile registered to the provided extension.
     * @throws edu.montana.gsoc.msusel.codetree.metrics.loc.UnknownProfileException
     *             When the provided extension has no registered profile
     * @throws IllegalArgumentException
     *             When the provided extension is null or empty
     */
    LoCProfile getProfileByExtension(String ext) throws UnknownProfileException {
        if (ext == null || ext.isEmpty())
            throw new IllegalArgumentException("Extension cannot be null or empty")
        if (!profileByExtension.containsKey(ext))
            throw new UnknownProfileException("No known LoC profile for extension " + ext)

        profileByExtension.get(ext.toLowerCase())
    }

    /**
     * Requests a profile for a given language
     *
     * @param lang
     *            Language name
     * @return The profile registered to the provided language
     * @throws UnknownProfileException
     *             When the provided language has no registered profile.
     * @throws IllegalArgumentException
     *             When the provided extension is null or empty
     */
    LoCProfile getProfileByLanguage(String lang) throws UnknownProfileException {
        if (lang == null || lang.isEmpty())
            throw new IllegalArgumentException("Language cannot be null or empty")
        if (!profileByExtension.containsKey(lang))
            throw new UnknownProfileException("No known LoC profile for language " + lang)

        profileByLanguage.get(lang.toLowerCase())
    }

    /**
     * Loads the default profiles from the JAR file
     */
    static void loadProfiles() {
        InputStream is = LoCProfileManager.class.getResourceAsStream(DEFAULT_LOCATION)

        Gson gson = new Gson()
        Type list = new TypeToken<List<LoCProfile>>() {
        }.getType()
        List<LoCProfile> profiles = gson.fromJson(gson.newJsonReader(new InputStreamReader(is)), list)

        for (LoCProfile profile : profiles) {
            LoCProfileManager.instance.addProfile(profile)
        }
    }
}

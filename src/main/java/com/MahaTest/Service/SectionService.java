package com.MahaTest.Service;

import com.MahaTest.Entity.Section;

import java.util.List;

    public interface SectionService {

        Section saveSection(Section section);

        List<Section> getAllSections();

        Section getSectionById(Long id);

        void deleteSection(Long id);
    }


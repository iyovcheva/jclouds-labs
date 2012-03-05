/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.vcloud.director.v1_5.features;

import static org.jclouds.vcloud.director.v1_5.VCloudDirectorMediaType.*;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jclouds.ovf.Envelope;
import org.jclouds.ovf.NetworkSection;
import org.jclouds.rest.annotations.BinderParam;
import org.jclouds.rest.annotations.EndpointParam;
import org.jclouds.rest.annotations.ExceptionParser;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.binders.BindToXMLPayload;
import org.jclouds.vcloud.director.v1_5.domain.*;
import org.jclouds.vcloud.director.v1_5.filters.AddVCloudAuthorizationToRequest;
import org.jclouds.vcloud.director.v1_5.functions.ThrowVCloudErrorOn4xx;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author Adam Lowe
 * @see org.jclouds.vcloud.director.v1_5.features.VAppTemplateClient
 */
@RequestFilters(AddVCloudAuthorizationToRequest.class)
public interface VAppTemplateAsyncClient {

   /**
    * @see org.jclouds.vcloud.director.v1_5.features.VAppTemplateClient#getVAppTemplate(URI)
    */
   @GET
   @Consumes(VAPP_TEMPLATE)
   @JAXBResponseParser
   @ExceptionParser(ThrowVCloudErrorOn4xx.class)
   ListenableFuture<VAppTemplate> getVAppTemplate(@EndpointParam URI reference);


   /**
    * @see org.jclouds.vcloud.director.v1_5.features.VAppTemplateClient#editVAppTemplate(URI, org.jclouds.vcloud.director.v1_5.domain.VAppTemplate)
    */
   @PUT
   @Produces(VAPP_TEMPLATE)
   @Consumes(TASK)
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplate(@EndpointParam URI templateURI,
                                           @BinderParam(BindToXMLPayload.class) VAppTemplate template);

   /**
    * @see VAppTemplateClient#deleteVappTemplate(URI)
    */
   @DELETE
   @Consumes(TASK)
   @JAXBResponseParser
   ListenableFuture<Task> deleteVappTemplate(@EndpointParam URI templateUri);

   /**
    * @see VAppTemplateClient#consolidateVappTemplate(URI)
    */
   @POST
   @Consumes(TASK)
   @Path("/action/consolidate")
   @JAXBResponseParser
   ListenableFuture<Task> consolidateVappTemplate(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#disableDownloadVappTemplate(URI)
    */
   @POST
   @Consumes(TASK)
   @Path("/action/disableDownload")
   @JAXBResponseParser
   ListenableFuture<Task> disableDownloadVappTemplate(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#enableDownloadVappTemplate(URI)
    */
   @POST
   @Consumes(TASK)
   @Path("/action/enableDownload")
   @JAXBResponseParser
   ListenableFuture<Task> enableDownloadVappTemplate(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#relocateVappTemplate(URI, org.jclouds.vcloud.director.v1_5.domain.RelocateParams)
    */
   @POST
   @Produces(RELOCATE_TEMPLATE)
   @Consumes(TASK)
   @Path("/action/relocate")
   @JAXBResponseParser
   ListenableFuture<Task> relocateVappTemplate(@EndpointParam URI templateURI,
                                               @BinderParam(BindToXMLPayload.class) RelocateParams params);

   /**
    * @see VAppTemplateClient#getVAppTemplateCustomizationSection(URI)
    */
   @GET
   @Consumes(CUSTOMIZATION_SECTION)
   @Path("/customizationSection")
   @JAXBResponseParser
   ListenableFuture<CustomizationSection> getVAppTemplateCustomizationSection(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editVAppTemplateCustomizationSection(URI, org.jclouds.vcloud.director.v1_5.domain.CustomizationSection)
    */
   @PUT
   @Produces(CUSTOMIZATION_SECTION)
   @Consumes(TASK)
   @Path("/customizationSection")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateCustomizationSection(@EndpointParam URI templateURI,
                                                               @BinderParam(BindToXMLPayload.class) CustomizationSection sectionType);

   /**
    * @see VAppTemplateClient#getVAppTemplateGuestCustomizationSection(URI)
    */
   @GET
   @Consumes(GUEST_CUSTOMIZATION_SECTION)
   @Path("/guestCustomizationSection")
   @JAXBResponseParser
   ListenableFuture<GuestCustomizationSection> getVAppTemplateGuestCustomizationSection(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editVAppTemplateGuestCustomizationSection(URI, org.jclouds.vcloud.director.v1_5.domain.GuestCustomizationSection)
    */
   @PUT
   @Produces(GUEST_CUSTOMIZATION_SECTION)
   @Consumes(TASK)
   @Path("/guestCustomizationSection")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateGuestCustomizationSection(@EndpointParam URI templateURI,
                                                                    @BinderParam(BindToXMLPayload.class) GuestCustomizationSection section);

   /**
    * @see VAppTemplateClient#getVappTemplateLeaseSettingsSection(URI)
    */
   @GET
   @Consumes(LEASE_SETTINGS_SECTION)
   @Path("/leaseSettingsSection")
   @JAXBResponseParser
   ListenableFuture<LeaseSettingsSection> getVappTemplateLeaseSettingsSection(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editVappTemplateLeaseSettingsSection(URI, org.jclouds.vcloud.director.v1_5.domain.LeaseSettingsSection)
    */
   @PUT
   @Produces(LEASE_SETTINGS_SECTION)
   @Consumes(TASK)
   @Path("/leaseSettingsSection")
   @JAXBResponseParser
   ListenableFuture<Task> editVappTemplateLeaseSettingsSection(@EndpointParam URI templateURI,
                                                               @BinderParam(BindToXMLPayload.class) LeaseSettingsSection settingsSection);

   /**
    * @see VAppTemplateClient#getVAppTemplateMetadata(URI)
    */
   @GET
   @Consumes(METADATA)
   @Path("/metadata")
   @JAXBResponseParser
   ListenableFuture<Metadata> getVAppTemplateMetadata(@EndpointParam URI templateURI);

   @PUT
   @Produces(METADATA)
   @Consumes(TASK)
   @Path("/metadata")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateMetadata(@EndpointParam URI templateURI,
                                                   @BinderParam(BindToXMLPayload.class) Metadata metadata);

   /**
    * @see VAppTemplateClient#getVAppTemplateMetadataValue(URI, String)
    */
   @GET
   @Consumes(METADATA_ENTRY)
   @Path("/metadata/{key}")
   @JAXBResponseParser
   ListenableFuture<MetadataValue> getVAppTemplateMetadataValue(@EndpointParam URI templateURI,
                                                                @PathParam("key") String key);

   /**
    * @see VAppTemplateClient#editVAppTemplateMetadataValue(URI, String, org.jclouds.vcloud.director.v1_5.domain.MetadataValue)
    */
   @PUT
   @Produces(METADATA_ENTRY)
   @Consumes(TASK)
   @Path("/metadata/{key}")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateMetadataValue(@EndpointParam URI templateURI,
                                                        @PathParam("key") String key,
                                                        @BinderParam(BindToXMLPayload.class) MetadataValue value);

   /**
    * @see VAppTemplateClient#deleteVAppTemplateMetadataValue(URI, String)
    */
   @DELETE
   @Consumes(TASK)
   @Path("/metadata/{key}")
   @JAXBResponseParser
   ListenableFuture<Task> deleteVAppTemplateMetadataValue(@EndpointParam URI templateURI,
                                                          @PathParam("key") String key);

   /**
    * @see VAppTemplateClient#getVAppTemplateNetworkConfigSection(URI)
    */
   @GET
   @Consumes(NETWORK_CONFIG_SECTION)
   @Path("/networkConfigSection")
   @JAXBResponseParser
   ListenableFuture<NetworkConfigSection> getVAppTemplateNetworkConfigSection(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editVAppTemplateNetworkConfigSection(URI, org.jclouds.vcloud.director.v1_5.domain.NetworkConfigSection)
    */
   @PUT
   @Produces(NETWORK_CONFIG_SECTION)
   @Consumes(TASK)
   @Path("/networkConfigSection")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateNetworkConfigSection(@EndpointParam URI templateURI,
                                                               @BinderParam(BindToXMLPayload.class) NetworkConfigSection section);

   /**
    * @see VAppTemplateClient#getVAppTemplateNetworkConnectionSection(URI)
    */
   @GET
   @Consumes(NETWORK_CONNECTION_SECTION)
   @Path("/networkConnectionSection")
   @JAXBResponseParser
   ListenableFuture<NetworkConnectionSection> getVAppTemplateNetworkConnectionSection(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editVAppTemplateNetworkConnectionSection(URI, org.jclouds.vcloud.director.v1_5.domain.NetworkConnectionSection)
    */
   @PUT
   @Produces(NETWORK_CONNECTION_SECTION)
   @Consumes(TASK)
   @Path("/networkConnectionSection")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateNetworkConnectionSection(@EndpointParam URI templateURI,
                                                                   @BinderParam(BindToXMLPayload.class) NetworkConnectionSection section);

   /**
    * @see VAppTemplateClient#getVAppTemplateNetworkSection(URI)
    */
   @GET
   @Consumes(NETWORK_SECTION)
   @Path("/networkSection")
   @JAXBResponseParser
   ListenableFuture<NetworkSection> getVAppTemplateNetworkSection(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editVAppTemplateNetworkSection(URI, NetworkSection)
    */
   @PUT
   @Produces(NETWORK_SECTION)
   @Consumes(TASK)
   @Path("/networkSection")
   @JAXBResponseParser
   ListenableFuture<Task> editVAppTemplateNetworkSection(@EndpointParam URI templateURI,
                                                         @BinderParam(BindToXMLPayload.class) NetworkSection section);

   /**
    * @see VAppTemplateClient#getVAppTemplateOvf(URI)
    */
   @GET
   @Consumes(ENVELOPE)
   @Path("/ovf")
   @JAXBResponseParser
   ListenableFuture<Envelope> getVAppTemplateOvf(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#getOwnerOfVAppTemplate(URI)
    */
   @GET
   @Consumes(OWNER)
   @Path("/owner")
   @JAXBResponseParser
   ListenableFuture<Owner> getOwnerOfVAppTemplate(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#getProductSectionsForVAppTemplate(URI)
    */
   @GET
   @Consumes(PRODUCT_SECTION_LIST)
   @Path("/productSections")
   @JAXBResponseParser
   ListenableFuture<ProductSectionList> getProductSectionsForVAppTemplate(@EndpointParam URI templateURI);

   /**
    * @see VAppTemplateClient#editProductSectionsForVAppTemplate(URI, org.jclouds.vcloud.director.v1_5.domain.ProductSectionList)
    */
   @PUT
   @Produces(PRODUCT_SECTION_LIST)
   @Consumes(TASK)
   @Path("/productSections")
   @JAXBResponseParser
   ListenableFuture<Task> editProductSectionsForVAppTemplate(@EndpointParam URI templateURI,
                                                             @BinderParam(BindToXMLPayload.class) ProductSectionList sections);

   // TODO shadowVms ?
}
